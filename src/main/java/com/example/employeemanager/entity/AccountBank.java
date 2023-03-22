package com.example.employeemanager.entity;

import com.example.employeemanager.controller.EmployeeController;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "account_bank")
@Getter
@Setter
public class AccountBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_number", nullable = false)
    private String accountNumber;
    @Column(name = "bank_name", nullable = false)
    private String bankName;
    @Column(name = "branch_location", nullable = false)
    private String branchLocation;
    @Column(name = "card_type", nullable = false)
    private String cardType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_employee_account_bank", referencedColumnName = "id")
    private Employee employeeAccount;
    private String nameEmployee;
    private String phoneEmployee;
    private String emailEmployee;

    public AccountBank(Long id, String accountNumber, String bankName, String branchLocation, String cardType) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.branchLocation = branchLocation;
        this.cardType = cardType;
        this.nameEmployee = employeeAccount.getFullName();
        this.phoneEmployee = employeeAccount.getPhoneNumber();
        this.emailEmployee = employeeAccount.getEmail();
    }

    public AccountBank() {

    }
}
