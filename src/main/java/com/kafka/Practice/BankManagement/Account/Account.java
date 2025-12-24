package com.kafka.Practice.BankManagement.Account;

public abstract class Account {
    private String accountId;
    private String password;
    private int balance;



    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    abstract Account getDetails();;

    public abstract boolean deposit(int amount);

    public abstract boolean fetch(int amount);
}
