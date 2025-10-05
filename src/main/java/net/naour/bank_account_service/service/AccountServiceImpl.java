package net.naour.bank_account_service.service;


import jakarta.transaction.Transactional;
import net.naour.bank_account_service.dto.BankAccountRequestDTO;
import net.naour.bank_account_service.dto.BankAccountResponseDTO;
import net.naour.bank_account_service.entities.BankAccount;
import net.naour.bank_account_service.mappers.AccountMapper;
import net.naour.bank_account_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository  bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper ;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
       BankAccountResponseDTO bankAccountResponseDTO =  accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;

    }
}
