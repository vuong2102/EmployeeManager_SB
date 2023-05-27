package Employee.management.service.clients;

import Employee.management.model.Employee;
import Employee.management.dto.clients.EmployeeResponse;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IEmployeeService{
    //    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    EmployeeResponse saveEmployee(Employee employee);
    String deleteEmployee(Long id);
    Page<Employee> getAllEmployees(String name, Integer pageNo, Integer pageSize);
}

