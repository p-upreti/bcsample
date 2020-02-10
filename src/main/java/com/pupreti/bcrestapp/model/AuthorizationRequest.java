package com.pupreti.bcrestapp.model;

import java.util.List;
import javax.validation.constraints.Size;

public class AuthorizationRequest {

    @Size(min=1)
    private List<String> accountIds;

    @Size(min=1, max=3)
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
