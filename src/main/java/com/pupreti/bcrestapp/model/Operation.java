package com.pupreti.bcrestapp.model;

import java.util.List;

public class Operation {

    public List<String> getResources() {
            return resources;
        }

        public void setResources(List<String> resources) {
            this.resources = resources;
        }

        private String action;
        private List<String> resources;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Operation operation = (Operation) o;
//            return Objects.equals(action, operation.action) &&
//                    Objects.equals(resources, operation.resources);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(action, resources);
//        }

        @Override
        public String toString() {
            return "Operation{" +
                    "action='" + action + '\'' +
                    ", resources=" + resources +
                    '}';
        }
}
