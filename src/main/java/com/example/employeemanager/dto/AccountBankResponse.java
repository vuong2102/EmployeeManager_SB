package com.example.employeemanager.dto;

import com.example.employeemanager.entity.AccountBank;

public record AccountBankResponse(Long id, String accountNumber, String bankName, String branchLocation, String cardType, Long fk_employee_account_bank) {
    public AccountBankResponse(AccountBank accountBank){
        this(accountBank.getId(),
                accountBank.getBankName(),
                accountBank.getAccountNumber(),
                accountBank.getBranchLocation(),
                accountBank.getCardType(),
                accountBank.getEmployeeAccount().getId());
    }
}
//accountBank.getBank().getNameBank(),
//        , String fk_account_bank
