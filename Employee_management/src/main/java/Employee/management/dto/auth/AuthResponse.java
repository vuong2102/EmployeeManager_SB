package Employee.management.dto.auth;

import Employee.management.model.Employee;

public record AuthResponse(Long id, String username, String email, String address,
                           String sdt, String role, String token) {
    public AuthResponse(Employee clientEntity, String token) {
        this(clientEntity.getId(), clientEntity.getUsername(), clientEntity.getEmail(), clientEntity.getAddress(),
             clientEntity.getPhoneNumber(), clientEntity.getRole(), token);
    }
}
