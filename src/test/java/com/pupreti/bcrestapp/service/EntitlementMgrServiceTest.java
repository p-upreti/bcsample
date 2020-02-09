package com.pupreti.bcrestapp.service;


import com.pupreti.bcrestapp.model.AuthorizationRequest;
import com.pupreti.bcrestapp.model.Operation;
import com.pupreti.bcrestapp.service.EntitlementMgrService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class EntitlementMgrServiceTest {

    @InjectMocks
    EntitlementMgrService entitlementMgrService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidateEntitlementAccess() {

        entitlementMgrService = new EntitlementMgrService();
        AuthorizationRequest req = new AuthorizationRequest();
        List<String> accounts = new ArrayList<String>();
        accounts.add("account001");
        accounts.add("account005");
        req.setAccountIds(accounts);
        List<Operation> operations = new ArrayList<>();
        List<String> resources = new ArrayList<>();
        resources.add("video");
        Operation opr = new Operation();
        opr.setAction("WRITE");
        opr.setResources(resources);
        operations.add(opr);
        req.setOperations(operations);

        boolean hasAccess = entitlementMgrService.validateEntitlementAccess("user001", req);
        assert(hasAccess==true);
    }
}
