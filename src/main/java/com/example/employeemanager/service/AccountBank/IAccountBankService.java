package com.example.employeemanager.service.AccountBank;

import com.example.employeemanager.dto.AccountBankResponse;
import com.example.employeemanager.dto.EmployeeResponse;
import com.example.employeemanager.entity.AccountBank;
import com.example.employeemanager.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IAccountBankService {
    List<AccountBank> getAllAccountBanks();
    Optional<AccountBank> getAccountBankById(Long id);
    AccountBankResponse saveAccountBank(AccountBank accountBank);
    String deleteAccountBank(Long id);
}
