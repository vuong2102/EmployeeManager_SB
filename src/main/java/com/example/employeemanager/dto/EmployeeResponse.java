package com.example.employeemanager.dto;

import com.example.employeemanager.entity.AccountBank;
import com.example.employeemanager.entity.Employee;

public record EmployeeResponse(Long id, String fullName, String address, String email, String phoneNumber) {
    public EmployeeResponse(Employee employee){
        this(employee.getId(),
                employee.getFullName(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getPhoneNumber());
    }
}
