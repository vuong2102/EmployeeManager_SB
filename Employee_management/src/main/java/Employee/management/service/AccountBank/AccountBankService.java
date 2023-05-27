package Employee.management.service.AccountBank;

import Employee.management.dto.AccountBank.AccountBankRequest;
import Employee.management.dto.AccountBank.AccountBankResponse;
import Employee.management.model.AccountBank;
import Employee.management.repository.accountBank.AccountBankRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountBankService implements IAccountBankService{
    @Autowired
    private AccountBankRepository accountBankRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Optional<AccountBank> getAccountBankById(Long id) {
        return accountBankRepository.findById(id);
    }
    @Override
    public AccountBank saveAccountBank(AccountBank accountBank) {
        return accountBankRepository.save(accountBank);
    }
//    @Override
//    public AccountBankResponse saveAccountBank(AccountBankResponse accountBankResponse) {
//        return accountBankRepository2.save(accountBankResponse);
//    }
    @Override
    public String deleteAccountBank(Long id) {
        accountBankRepository.deleteById(id);
        return "Delete SuccessFully";
    }
}
