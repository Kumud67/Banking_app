package com.bank.banking_app.dto;

public class CreateAccountRequest {

    private String name;
    private double initialBalance;

    public String getName() {
        return name;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }
}