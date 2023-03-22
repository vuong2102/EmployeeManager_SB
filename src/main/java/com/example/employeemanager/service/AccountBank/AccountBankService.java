package com.example.employeemanager.service.AccountBank;

import com.example.employeemanager.dto.AccountBankResponse;
import com.example.employeemanager.dto.EmployeeResponse;
import com.example.employeemanager.entity.AccountBank;
import com.example.employeemanager.entity.Employee;
import com.example.employeemanager.repository.AccountBankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountBankService implements IAccountBankService {
    private final AccountBankRepository accountBankRepository;
    @Override
    public List<AccountBank> getAllAccountBanks() {
        return accountBankRepository.findAll();
    }
    @Override
    public Optional<AccountBank> getAccountBankById(Long id) {
        return accountBankRepository.findById(id);
    }
    @Override
    public AccountBankResponse saveAccountBank(AccountBank accountBank) {
        AccountBank accountBankk = accountBankRepository.save(accountBank);
        return new AccountBankResponse(accountBankk);
    }
    @Override
    public String deleteAccountBank(Long id) {
        accountBankRepository.deleteById(id);
        return "Delete SuccessFully";
    }
}
