package Employee.management.service.AccountBank;

import Employee.management.dto.AccountBank.AccountBankRequest;
import Employee.management.dto.AccountBank.AccountBankResponse;
import Employee.management.model.AccountBank;

import java.util.Optional;

public interface IAccountBankService {
    Optional<AccountBank> getAccountBankById(Long id);
    AccountBank saveAccountBank(AccountBank accountBank);
//    AccountBankResponse saveAccountBank(AccountBankResponse accountBank);
    String deleteAccountBank(Long id);
}
