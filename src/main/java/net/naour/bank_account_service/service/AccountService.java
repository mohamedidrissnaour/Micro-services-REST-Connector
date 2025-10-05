package net.naour.bank_account_service.service;

import net.naour.bank_account_service.dto.BankAccountRequestDTO;
import net.naour.bank_account_service.dto.BankAccountResponseDTO;
import net.naour.bank_account_service.entities.BankAccount;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}

