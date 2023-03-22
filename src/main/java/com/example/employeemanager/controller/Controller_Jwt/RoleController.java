package com.example.employeemanager.controller.Controller_Jwt;

import com.example.employeemanager.entity.Entity_Jwt.Role;
import com.example.employeemanager.repository.Repository_Jwt.RoleRepository;
import com.example.employeemanager.service.Service_Jwt.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class RoleController {
    private IRoleService iRoleService;
    @Autowired
    private RoleRepository roleRepository;
    @GetMapping("/all-role")
    public List<Role> getAllRolees(){
        return iRoleService.getAllRoles();
    }
    @PostMapping("/createNewRole")
    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
