package com.bank.banking_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.banking_app.dto.CreateAccountRequest;
import com.bank.banking_app.model.Account;
import com.bank.banking_app.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody CreateAccountRequest request) {

        return accountService.createAccount(request);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {

        return accountService.getAccount(id);
    }

    @PostMapping("/{id}/deposit")
    public Account deposit(
            @PathVariable Long id,
            @RequestParam double amount
    ) {

        return accountService.deposit(id, amount);
    }
}