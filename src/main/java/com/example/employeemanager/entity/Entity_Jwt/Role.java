package com.example.employeemanager.entity.Entity_Jwt;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Entity
@Data
public class Role {
    @Id
    private String roleName;
    private String roleDescription;

}
