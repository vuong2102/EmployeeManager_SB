package Employee.management.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Employee.management.dto.auth.UserResponse;
import Employee.management.dto.clients.EmployeeResponse;
import Employee.management.model.Employee;
import Employee.management.repository.clients.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
    private final EmployeeRepository iClientRepo;

    @Override
    public EmployeeResponse saveUser(UserResponse userResponse) {
        Employee clientEntity = new Employee(userResponse);
        Employee clientEntity1 = iClientRepo.save(clientEntity);
        return new EmployeeResponse(clientEntity1);
    }

    @Override
    public Employee fetchUser(String email) {
        return iClientRepo.findByEmail(email);
    }
}
