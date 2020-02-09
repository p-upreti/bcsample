package com.pupreti.bcrestapp.model;

import java.util.List;

public class AuthorizationRequest {

    private List<String> accountIds;
    private List<Operation> operations;

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
