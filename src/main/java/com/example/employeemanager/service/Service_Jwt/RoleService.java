package com.example.employeemanager.service.Service_Jwt;

import com.example.employeemanager.dto.Jwt.RoleResponse;
import com.example.employeemanager.entity.Entity_Jwt.Role;
import com.example.employeemanager.repository.Repository_Jwt.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleService implements IRoleService{
    private final RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
    @Override
    public RoleResponse saveRole(Role role){
        Role role1 = roleRepository.save(role);
        return new RoleResponse(role1);
    }
}
