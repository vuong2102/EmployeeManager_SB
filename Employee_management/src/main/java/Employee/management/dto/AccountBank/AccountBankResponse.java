package Employee.management.dto.AccountBank;

import Employee.management.model.AccountBank;
import lombok.Data;

//@Data
//public record AccountBankResponse(Long id, String bank, String accountBank, String branch, Long employeeId) {
//    public AccountBankResponse(AccountBankRequest accountBank, Long id){
//        this(accountBank.getId(),
//                accountBank.getBank(),
//                accountBank.getAccountNumber(),
//                accountBank.getBranch(),
//                id);
//    }
//}
@Data
public class AccountBankResponse{
    private Long id;
    private String bank;
    private String accountNumber;
    private String branch;
    private String cardType;
    private Long employeeId;
}
