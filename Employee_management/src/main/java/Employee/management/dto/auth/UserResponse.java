package Employee.management.dto.auth;

import Employee.management.model.Employee;

public record UserResponse(String username, String email, String address, String phoneNumber, String position,
                           String password, String role) {
    public UserResponse(Employee clientEntity, String password) {
        this(clientEntity.getUsername(), clientEntity.getEmail(), clientEntity.getAddress(), clientEntity.getPhoneNumber(), clientEntity.getPosition(), password, clientEntity.getRole());
    }
}

