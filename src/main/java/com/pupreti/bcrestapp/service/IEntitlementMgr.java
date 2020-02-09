package com.pupreti.bcrestapp.service;

import com.pupreti.bcrestapp.model.AuthorizationRequest;

public interface IEntitlementMgr {
    Boolean validateEntitlementAccess(String userId, AuthorizationRequest authReq);
}
