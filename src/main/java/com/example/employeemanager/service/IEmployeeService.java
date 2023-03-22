package com.example.employeemanager.service;

import com.example.employeemanager.dto.EmployeeResponse;
import com.example.employeemanager.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService{
//    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    EmployeeResponse saveEmployee(Employee employee);
    String deleteEmployee(Long id);
    Page<Employee> getAllEmployees(String name, Integer pageNo, Integer pageSize);
}
