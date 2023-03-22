package com.example.employeemanager.repository;

import com.example.employeemanager.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, String> {

//    Optional<Bank> findByName(String name);
}
