package com.example.employeemanager.controller;


import com.example.employeemanager.dto.AccountBankResponse;
import com.example.employeemanager.entity.AccountBank;
import com.example.employeemanager.exception.ResourceNotFoundException;
import com.example.employeemanager.repository.AccountBankRepository;
import com.example.employeemanager.service.AccountBank.IAccountBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AccountBankController {
    private final IAccountBankService iAccountBankService;
    @Autowired
    private AccountBankRepository accountBankRepository;
    @GetMapping("/account-banks")
    public List<AccountBankResponse> getAllAccountBanks(){
        List<AccountBank> allAccountBanks = iAccountBankService.getAllAccountBanks();
        return allAccountBanks.stream().map(this::AccountBankResponse).toList();
    }
    @GetMapping("/account-banks/{id}")
    public ResponseEntity<AccountBank> getAccountBankById(@PathVariable Long id){
        AccountBank accountBank = accountBankRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AccountBank not exist with accountNumber: " + id));
        return ResponseEntity.ok(accountBank);
    }
    private AccountBankResponse AccountBankResponse(AccountBank AccountBank) {
        return new AccountBankResponse(AccountBank);
    }
    @PostMapping("/create-account-bank")
    public AccountBankResponse saveNewAccountBank(@RequestBody AccountBank accountBank) {
        return iAccountBankService.saveAccountBank(accountBank);
    }
    @DeleteMapping("/delete-account-bank/{id}")
    public String deleteAccountBankById(@PathVariable("id") Long id){
        return iAccountBankService.deleteAccountBank(id);
    }

    @PutMapping("/update-account-bank/{id}")
    public ResponseEntity<AccountBank> updateAccountBank(@PathVariable Long id, @RequestBody AccountBank accountBankDetails){
        AccountBank accountBank = accountBankRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AccountBank not exist with id: " + id));

        accountBank.setAccountNumber(accountBankDetails.getAccountNumber());
        accountBank.setBranchLocation(accountBankDetails.getBranchLocation());
        accountBank.setCardType(accountBankDetails.getCardType());
        AccountBank updateAccountBank = accountBankRepository.save(accountBank);

        return ResponseEntity.ok(updateAccountBank);
    }
}
