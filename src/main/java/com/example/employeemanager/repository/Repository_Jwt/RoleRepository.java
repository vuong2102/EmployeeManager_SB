package com.example.employeemanager.repository.Repository_Jwt;

import com.example.employeemanager.entity.Entity_Jwt.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>, CrudRepository<Role, String> {
}
