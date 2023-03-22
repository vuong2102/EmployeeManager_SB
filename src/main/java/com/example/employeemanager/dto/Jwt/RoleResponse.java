package com.example.employeemanager.dto.Jwt;

import com.example.employeemanager.entity.Entity_Jwt.Role;

public record RoleResponse(String nameRole, String roleDescription) {
    public RoleResponse(Role role){
        this(role.getRoleName(),
                role.getRoleDescription());
    }
}
