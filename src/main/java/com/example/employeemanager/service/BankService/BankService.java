package com.example.employeemanager.service.BankService;

import com.example.employeemanager.dto.BankResponse;
import com.example.employeemanager.entity.Bank;
import com.example.employeemanager.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankService implements IBankService {
    private final BankRepository bankRepository;
    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }
    @Override
    public Optional<Bank> getBankByName(String name) {
        return Optional.empty();
    }

    //    @Override
//    public Optional<Bank> getBankByName(String id) {
//        return bankRepository.findByName(id);
//    }
    @Override
    public BankResponse saveBank(Bank bank) {
        Bank bank1 = bankRepository.save(bank);
        return new BankResponse(bank1);
    }
    @Override
    public String deleteBank(String id) {
        bankRepository.deleteById(id);
        return "Delete SuccessFully";
    }
}
