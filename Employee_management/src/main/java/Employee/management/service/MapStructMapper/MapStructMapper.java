package Employee.management.service.MapStructMapper;

import Employee.management.dto.AccountBank.AccountBankRequest;
import Employee.management.model.AccountBank;
import org.springframework.stereotype.Component;

@Component
public class MapStructMapper implements IMapStructMapper{
    @Override
    public AccountBank userPostDtoToUser(AccountBankRequest userPostDto) {
        if ( userPostDto == null ) {
            return null;
        }
        AccountBank user = new AccountBank();

        user.setId( userPostDto.getId() );
        user.setBank(userPostDto.getBank());
        user.setAccountNumber(userPostDto.getAccountNumber());
        user.setBranch(userPostDto.getBranch());

        return user;
    }
}
