package com.example.employeemanager.repository;

import com.example.employeemanager.entity.AccountBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBankRepository extends JpaRepository<AccountBank, Long> {
}
