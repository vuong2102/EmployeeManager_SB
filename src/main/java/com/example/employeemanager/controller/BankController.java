package com.example.employeemanager.controller;

import com.example.employeemanager.dto.BankResponse;
import com.example.employeemanager.entity.Bank;
import com.example.employeemanager.exception.ResourceNotFoundException;
import com.example.employeemanager.repository.BankRepository;
import com.example.employeemanager.service.BankService.IBankService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class BankController {
    @Autowired
    private BankRepository bankRepository;
    private final IBankService iBankService;

    @GetMapping("/banks")
    public List<BankResponse> getAllBanks() {
        List<Bank> allBanks = iBankService.getAllBanks();
        return allBanks.stream().map(this::bankResponse).toList();
    }
//    @GetMapping("/banks/{name}")
//    public ResponseEntity<Bank> getBankByName(@PathVariable String name) {
//        Bank bank = bankRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Bank not exist with id: " + name));
//        return ResponseEntity.ok(bank);
//    }

    private BankResponse bankResponse(Bank bank) {
        return new BankResponse(bank);
    }

    @PostMapping("/create-bank")
    public BankResponse saveNewBank(@RequestBody Bank bank) {
        return iBankService.saveBank(bank);
    }

    @DeleteMapping("/delete-bank/{id}")
    public String deleteBankById(@PathVariable("id") String id) {
        return iBankService.deleteBank(id);
    }

    @PutMapping("/update-bank/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable String name, @RequestBody Bank bankDetails) {
        Bank bank = bankRepository.findById(name).orElseThrow(() -> new ResourceNotFoundException("Bank not exist with id: " + name));

        bank.setNameBank(bankDetails.getNameBank());
        bank.setLocation(bankDetails.getLocation());

        Bank updateBank = bankRepository.save(bank);
        return ResponseEntity.ok(updateBank);
    }
}
