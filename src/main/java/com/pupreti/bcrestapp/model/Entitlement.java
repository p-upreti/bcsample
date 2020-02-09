package com.pupreti.bcrestapp.model;

import java.util.List;


public class Entitlement {

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Entitlement{" +
                "accountId='" + accountId + '\'' +
                ", operations=" + operations +
                '}';
    }

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
//
////        @Override
////        public boolean equals(Object o) {
////            if (this == o) return true;
////            if (o == null || getClass() != o.getClass()) return false;
////            Operation operation = (Operation) o;
////            return Objects.equals(action, operation.action) &&
////                    Objects.equals(resources, operation.resources);
////        }
////
////        @Override
////        public int hashCode() {
////            return Objects.hash(action, resources);
////        }
//
//        @Override
//        public String toString() {
//            return "Operation{" +
//                    "action='" + action + '\'' +
//                    ", resources=" + resources +
//                    '}';
//        }
//    }
    private String accountId;
//    private String operations;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

//    public String getOperations() {
//        return operations;
//    }
//
//    public void setOperations(String operations) {
//        this.operations = operations;
//    }
    private List<Operation> operations;


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Entitlement that = (Entitlement) o;
//        return Objects.equals(accountId, that.accountId) &&
//                Objects.equals(operations, that.operations);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(accountId, operations);
//    }
}
