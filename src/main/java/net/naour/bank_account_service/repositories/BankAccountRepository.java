package net.naour.bank_account_service.repositories;

import net.naour.bank_account_service.entities.AccountType;
import net.naour.bank_account_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource //demmare moi un webservice Restfull de spring data rest qui permet de gerer bankaccount
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    @RestResource(path = "/byType") //appeler la methode par un nom
    List<BankAccount> findByType(@Param("t") AccountType type);

}
