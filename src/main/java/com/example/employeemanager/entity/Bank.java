package com.example.employeemanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "bank")
@RequiredArgsConstructor
public class Bank {
    @Id
    @Column(name = "nameBank")
    private String nameBank;
    @Column(name = "location")
    private String location;
//    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
//    private List<AccountBank> bankAccountBanks;
}
