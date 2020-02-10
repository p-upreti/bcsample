package com.pupreti.bcrestapp.service;


import com.pupreti.bcrestapp.model.AuthorizationRequest;
import com.pupreti.bcrestapp.model.Operation;
import com.pupreti.bcrestapp.service.EntitlementMgrService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@Import(EntitlementMgrService.class)
public class EntitlementMgrServiceTest {

//    @InjectMocks
    @Autowired
    EntitlementMgrService entitlementMgrService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidateEntitlementAccessReturnsTrue() {

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

    @Test
    public void testValidateEntitlementAccessReturnsFalse() {
        AuthorizationRequest req = new AuthorizationRequest();
        List<String> accounts = new ArrayList<String>();
        accounts.add("account001");
        accounts.add("account005");
        req.setAccountIds(accounts);
        List<Operation> operations = new ArrayList<>();
        List<String> resources = new ArrayList<>();
        resources.add("video");
        resources.add("playlist");
        Operation opr = new Operation();
        opr.setAction("WRITE");
        opr.setResources(resources);
        operations.add(opr);
        req.setOperations(operations);

        boolean hasAccess = entitlementMgrService.validateEntitlementAccess("user001", req);
        assert(hasAccess==false);
    }

    @Test
    public void testAccessFailureWithMissingResourceWrite() {
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

        List<String> resources2 = new ArrayList<>();
        resources2.add("video");
        Operation opr2 = new Operation();
        opr2.setAction("READ");
        opr2.setResources(resources2);
        operations.add(opr2);

        req.setOperations(operations);

        boolean hasAccess = entitlementMgrService.validateEntitlementAccess("user001", req);
        assert(hasAccess==false);
    }
}
