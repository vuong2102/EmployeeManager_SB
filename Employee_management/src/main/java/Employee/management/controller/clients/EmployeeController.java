package Employee.management.controller.clients;

import Employee.management.dto.AccountBank.AccountBankRequest;
import Employee.management.dto.AccountBank.AccountBankResponse;
import Employee.management.dto.clients.EmployeeResponse;
import Employee.management.model.AccountBank;
import Employee.management.model.HttpResponse;
import Employee.management.model.Employee;
import Employee.management.repository.clients.EmployeeRepository;
import Employee.management.repository.error.ResourceNotFoundException;
import Employee.management.service.AccountBank.IAccountBankService;
import Employee.management.service.MapStructMapper.IMapStructMapper;
import Employee.management.service.MapStructMapper.MapStructMapper;
import Employee.management.service.clients.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.time.LocalTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    private final IEmployeeService iEmployeeService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IAccountBankService iAccountBankService;
    @GetMapping("/employees")
    public ResponseEntity<HttpResponse> getAllEmployees(@RequestParam Optional<String> name,
                                                        @RequestParam Optional<Integer> pageNo,
                                                        @RequestParam Optional<Integer> pageSize) throws InterruptedException{
//        TimeUnit.SECONDS.sleep(1);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("page", iEmployeeService.getAllEmployees(name.orElse(""), pageNo.orElse(0), pageSize.orElse(10))))
                        .message("Employees Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }
    @GetMapping("/employees2")
    public List<Employee> getAllEmployees2(){
        return employeeRepository.findAll();
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));
        return ResponseEntity.ok(employee);
    }
    private EmployeeResponse employeeResponse(Employee employee) {
        return new EmployeeResponse(employee);
    }
    @PostMapping("/employees/{id}/create-account-bank")
    public AccountBankResponse saveNewAccountBank(@RequestBody AccountBankRequest accountBankRequest, @PathVariable Long id) {
//        accountBankResponse.setEmployeeId(id);
        AccountBank accountBank = modelMapper.map(accountBankRequest, AccountBank.class);
        accountBank.setEmployee(getEmployeeById(id).getBody());
        AccountBank accountBankCreated = iAccountBankService.saveAccountBank(accountBank);
        return modelMapper.map(accountBankCreated, AccountBankResponse.class);
    }
    @PostMapping("/create-employee")
    public EmployeeResponse saveNewEmployee(@RequestBody Employee employee) {
        return iEmployeeService.saveEmployee(employee);
    }
    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        return iEmployeeService.deleteEmployee(id);
    }
    @PutMapping("/update-employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));

        employee.setUsername(employeeDetails.getUsername());
        employee.setAddress(employeeDetails.getAddress());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhoneNumber(employeeDetails.getPhoneNumber());

        Employee updateEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }
}
