package com.example.employeemanager.dto;


import com.example.employeemanager.entity.Bank;

public record BankResponse(String nameBank, String location) {
    public BankResponse(Bank bank){
        this(bank.getNameBank(), bank.getLocation());
    }
}
