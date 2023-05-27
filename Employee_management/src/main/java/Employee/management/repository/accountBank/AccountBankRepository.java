package Employee.management.repository.accountBank;

import Employee.management.model.AccountBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBankRepository extends JpaRepository<AccountBank, Long> {
}
