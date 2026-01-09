package com.thesis.accounts_microservice.mapper;

import com.thesis.accounts_microservice.dto.AccountsDTO;
import com.thesis.accounts_microservice.entity.Accounts;

public class AccountsMapper {
    public static AccountsDTO mapToAccountsDTO(Accounts accounts, AccountsDTO accountsDTO) {
        accountsDTO.setAccountNumber(accounts.getAccountNumber());
        accountsDTO.setAccountType(accounts.getAccountType());
        accountsDTO.setBranchAddresses(accounts.getBranchAddress());
        return accountsDTO;
    }

    public static Accounts mapToAccountEntity(Accounts accounts, AccountsDTO accountsDTO) {
        accounts.setAccountNumber(accountsDTO.getAccountNumber());
        accounts.setAccountType(accountsDTO.getAccountType());
        accounts.setBranchAddress(accountsDTO.getBranchAddresses());
        return accounts;
    }
}
