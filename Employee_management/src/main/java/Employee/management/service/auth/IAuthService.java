package Employee.management.service.auth;

import Employee.management.dto.auth.UserResponse;
import Employee.management.dto.clients.EmployeeResponse;
import Employee.management.model.Employee;

public interface IAuthService {

    EmployeeResponse saveUser(UserResponse userResponse);

    Employee fetchUser(String email);

}
