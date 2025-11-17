package com.medical.medservice.domains.user;

public enum UserRole {
    USER("user"),
    MANAGER("manager"),
    ADMIN("admin");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
