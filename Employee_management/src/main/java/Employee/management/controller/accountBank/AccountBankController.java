package Employee.management.controller.accountBank;

import Employee.management.dto.AccountBank.AccountBankRequest;
import Employee.management.dto.AccountBank.AccountBankResponse;
import Employee.management.dto.clients.EmployeeResponse;
import Employee.management.model.AccountBank;
import Employee.management.model.Employee;
import Employee.management.repository.accountBank.AccountBankRepository;
import Employee.management.repository.error.ResourceNotFoundException;
import Employee.management.service.AccountBank.IAccountBankService;
import Employee.management.service.clients.EmployeeService;
import Employee.management.service.clients.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AccountBankController {
    @Autowired
    private final IAccountBankService iAccountBankService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountBankRepository accountBankRepository;
    @GetMapping("account-bank/{id}")
    public ResponseEntity<AccountBank> getAccountBankById(@PathVariable Long id){
        AccountBank accountBank = accountBankRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AccountBank not exist with id: " + id));
        return ResponseEntity.ok(accountBank);
    }
    @PutMapping("/update-account-bank/{id}")
    public ResponseEntity<AccountBank> updateAccountBank(@PathVariable Long id, @RequestBody AccountBank accountBankDetails){
        AccountBank accountBank = accountBankRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("accountBank not exist with id: " + id));

        accountBank.setBank(accountBankDetails.getBank());
        accountBank.setAccountNumber(accountBankDetails.getAccountNumber());
        accountBank.setBranch(accountBankDetails.getBranch());
        accountBank.setCardType(accountBankDetails.getCardType());

        AccountBank updateAccountBank = accountBankRepository.save(accountBank);
        return ResponseEntity.ok(updateAccountBank);
    }
}
