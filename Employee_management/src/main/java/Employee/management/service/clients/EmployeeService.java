package Employee.management.service.clients;

import Employee.management.dto.clients.EmployeeResponse;
import Employee.management.model.Employee;
import Employee.management.repository.clients.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployeeService implements IEmployeeService{
    private final EmployeeRepository employeeRepository;
    @Override
    public Page<Employee> getAllEmployees(String name, Integer pageNo, Integer pageSize) {
        log.info("Fetching employees for page {} of size {}", pageNo, pageSize);
        return this.employeeRepository.findByUsernameContaining(name, PageRequest.of(pageNo, pageSize));
    }
    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    @Override
    public EmployeeResponse saveEmployee(Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return new EmployeeResponse(employee1);
    }
    @Override
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Delete SuccessFully";
    }
}
