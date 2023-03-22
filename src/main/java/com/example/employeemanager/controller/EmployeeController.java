package com.example.employeemanager.controller;

import com.example.employeemanager.dto.EmployeeResponse;
import com.example.employeemanager.entity.Employee;
import com.example.employeemanager.entity.HttpResponse;
import com.example.employeemanager.exception.ResourceNotFoundException;
import com.example.employeemanager.repository.EmployeeRepository;
import com.example.employeemanager.service.EmployeeService;
import com.example.employeemanager.service.IEmployeeService;
import com.mysql.cj.x.protobuf.Mysqlx;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
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
//    @GetMapping("/employees")
//    public List<EmployeeResponse> getAllEmployees(){
//        List<Employee> allEmployees = iEmployeeService.getAllEmployees();
//        return allEmployees.stream().map(this::employeeResponse).toList();
//    }
//    @GetMapping("/employees")
//    public ResponseEntity<?> getEmployees(@RequestParam Optional<Integer> pageNo,
//                                             @RequestParam Optional<Integer> pageSize){
//        Page<Employee> employeePage = iEmployeeService.getAllEmployees(pageNo.orElse(0), pageSize.orElse(10));
//        if(employeePage.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(employeePage, HttpStatus.OK);
//    }
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

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));
        return ResponseEntity.ok(employee);
    }
    private EmployeeResponse employeeResponse(Employee employee) {
        return new EmployeeResponse(employee);
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

        employee.setFullName(employeeDetails.getFullName());
        employee.setAddress(employeeDetails.getAddress());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhoneNumber(employeeDetails.getPhoneNumber());

        Employee updateEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    //get all employees
//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees(){
//        return employeeRepository.findAll();
//    }
//
//    //create employee
//    @PostMapping("/create-employees")
//    public Employee createEmployee(@RequestBody Employee employee){
//        return employeeRepository.save(employee);
//    }
//
//    @GetMapping("/employees/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
//        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));
//        return ResponseEntity.ok(employee);
//    }
//
//    @PutMapping("/employees/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
//        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));
//
//        employee.setFullName(employeeDetails.getFullName());
//        employee.setAddress(employeeDetails.getAddress());
//        employee.setEmail(employeeDetails.getEmail());
//        employee.setPhoneNumber(employeeDetails.getPhoneNumber());
//
//        Employee updateEmployee = employeeRepository.save(employee);
//        return ResponseEntity.ok(updateEmployee);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
//        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
//        employeeRepository.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }
}
