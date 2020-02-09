package com.pupreti.bcrestapp.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

import java.util.List;
import java.util.Objects;

public class User {
    private String userId;
    private List<Entitlement> entitlements;
//
//    public User(String userId) {
//        this.userId = userId;
//    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Entitlement> getEntitlements() {
        return entitlements;
    }
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    public void setEntitlements(List<Entitlement> entitlements) {
        this.entitlements = entitlements;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", entitlements=" + entitlements +
                '}';
    }

}
