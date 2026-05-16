package com.bank.banking_app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bank.banking_app.dto.CreateAccountRequest;
import com.bank.banking_app.model.Account;

@Service
public class AccountService {

    private final Map<Long, Account> accounts = new HashMap<>();

    private Long currentId = 1L;

    public Account createAccount(CreateAccountRequest request) {

        Account account = new Account(
                currentId,
                request.getName(),
                request.getInitialBalance()
        );

        accounts.put(currentId, account);

        currentId++;

        return account;
    }

    public Account getAccount(Long id) {
        return accounts.get(id);
    }

    public Account deposit(Long id, double amount) {

        Account account = accounts.get(id);

        if (account != null) {
            account.setBalance(account.getBalance() + amount);
        }

        return account;
    }
}