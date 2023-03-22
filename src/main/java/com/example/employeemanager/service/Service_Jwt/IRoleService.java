package com.example.employeemanager.service.Service_Jwt;

import com.example.employeemanager.dto.EmployeeResponse;
import com.example.employeemanager.dto.Jwt.RoleResponse;
import com.example.employeemanager.entity.Employee;
import com.example.employeemanager.entity.Entity_Jwt.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getAllRoles();
    RoleResponse saveRole(Role role);

}
