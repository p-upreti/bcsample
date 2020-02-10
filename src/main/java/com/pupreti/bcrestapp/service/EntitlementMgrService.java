package com.pupreti.bcrestapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pupreti.bcrestapp.model.AuthorizationRequest;
import com.pupreti.bcrestapp.model.Entitlement;
import com.pupreti.bcrestapp.model.Operation;
import com.pupreti.bcrestapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class EntitlementMgrService implements IEntitlementMgr {

    private Map<String, List<Entitlement>> masterUser;

    @Autowired
    ResourceLoader resourceLoader;

    @Value("classpath:user_entitlements.json")
    Resource resourceFile;

    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

        try {
            InputStream inputStream = resourceFile.getInputStream();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            List<User> users = mapper.readValue(inputStream,  new TypeReference<List<User>>() {
            });
            masterUser = new HashMap<>();
            for(User user: users) {
                masterUser.put(user.getUserId(), user.getEntitlements());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Boolean validateEntitlementAccess(String userId, AuthorizationRequest authReq) {
        Boolean hasAccess = false;
        List<Entitlement> userEntitlement = getMasterUser().get(userId);
        if (userEntitlement != null && !userEntitlement.isEmpty()) {
            hasAccess = isEntitled(userEntitlement, authReq);
        } else {
            System.out.println("entitlement for user not found:");
        }
        return hasAccess;
    }

    public Map<String, List<Entitlement>> getMasterUser() {
        return masterUser;
    }

    public Boolean isEntitled(List<Entitlement> userEntitlements, AuthorizationRequest req) {
        boolean hasAccess =false;
        for(String reqAccountId: req.getAccountIds()) {
            List<Operation> allowOps = getOperationsByAccount(reqAccountId, userEntitlements);
            if(allowOps != null) {
                hasAccess = hasOperationMatch(allowOps, req.getOperations());
            }
            if(!hasAccess) return false;
        }
        return hasAccess;
    }
    private List<Operation> getOperationsByAccount(String accountId,List<Entitlement> userEntitlements) {
        for(Entitlement ent: userEntitlements) {
            if(ent.getAccountId().equals(accountId)) {
                return ent.getOperations();
            }
        }
        return null;
    }
    public Boolean hasOperationMatch(List<Operation> entOperations, List<Operation> reqOperations) {
        boolean hasAccess = false;
        for(Operation reqOp: reqOperations) {
            boolean matchFound = false;
            for (Operation entOp : entOperations) {
                if (reqOp.getAction().toLowerCase().equals(entOp.getAction().toLowerCase()) &&
                        entOp.getResources().containsAll(reqOp.getResources())) {
                    matchFound = true;
                }
            }
            if(!matchFound) return false;
        }
        return true;
    }
}
