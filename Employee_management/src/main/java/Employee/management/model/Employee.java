package Employee.management.model;

import Employee.management.dto.AccountBank.AccountBankRequest;
import Employee.management.dto.auth.UserResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String address;
    private String phoneNumber;
    private String position;
    private String password;
    private String role;
    @JsonIgnoreProperties("employee")
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountBank> accountBanks = new ArrayList<>();

    public Employee(UserResponse userResponse){
        this.username=userResponse.username();
        this.email=userResponse.email();
        this.address=userResponse.address();
        this.password=userResponse.password();
        this.phoneNumber=userResponse.phoneNumber();
        this.position=userResponse.position();
        this.role="user";
    }
}
