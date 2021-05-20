package com.pwc.assignment.data.entities;

public enum UserRoles {
    ADMIN("ADMIN"), USER("USER");

    String role;

    @Override
    public String toString() {
        return role;
    }

    UserRoles(String role) {
        this.role = role;
    }

    public static UserRoles ofString(String role){
        if (role.equalsIgnoreCase(UserRoles.ADMIN.role))
            return UserRoles.ADMIN;
        if (role.equalsIgnoreCase(UserRoles.USER.role))
            return UserRoles.USER;
        else throw new RuntimeException("No role with this name!");
    }
}
