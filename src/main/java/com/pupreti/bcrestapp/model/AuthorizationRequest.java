package com.pupreti.bcrestapp.model;

import java.util.List;

public class AuthorizationRequest {


//    public static class Operation {
//
//        public List<String> getResources() {
//            return resources;
//        }
//
//        public void setResources(List<String> resources) {
//            this.resources = resources;
//        }
//
//        private String action;
//        private List<String> resources;
//
//        public String getAction() {
//            return action;
//        }
//
//        public void setAction(String action) {
//            this.action = action;
//        }
//    }

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
