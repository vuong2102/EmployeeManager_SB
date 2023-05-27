package Employee.management.dto.clients;

import Employee.management.model.Employee;

public record EmployeeResponse(Long id, String username,
                               String email, String address,
                               String phoneNumber, String position, String role) {
    public EmployeeResponse(Employee clientEntity) {
        this(clientEntity.getId(),
                clientEntity.getUsername(),
                clientEntity.getEmail(),
                clientEntity.getAddress(),
                clientEntity.getPhoneNumber(),
                clientEntity.getPosition(),
                clientEntity.getRole());
    }
}