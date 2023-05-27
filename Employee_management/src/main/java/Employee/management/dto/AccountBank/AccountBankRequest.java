package Employee.management.dto.AccountBank;

import lombok.Data;

@Data
public class AccountBankRequest {
    private Long id;
    private String bank;
    private String accountNumber;
    private String branch;
    private String cardType;

}
