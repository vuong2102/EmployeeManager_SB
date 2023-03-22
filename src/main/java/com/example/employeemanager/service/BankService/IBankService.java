package com.example.employeemanager.service.BankService;

import com.example.employeemanager.entity.Bank;
import com.example.employeemanager.dto.BankResponse;

import java.util.List;
import java.util.Optional;

public interface IBankService {
    List<Bank> getAllBanks();
    Optional<Bank> getBankByName(String name);
    BankResponse saveBank(Bank bank);
    String deleteBank(String name);
}
