package Employee.management.service.MapStructMapper;

import Employee.management.dto.AccountBank.AccountBankRequest;
import Employee.management.model.AccountBank;

public interface IMapStructMapper {
    AccountBank userPostDtoToUser(AccountBankRequest userPostDto);
}
