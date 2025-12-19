package com.kafka.Practice.BankManagement.Account;

public class CurrentAccount extends Account{
    private String accountId;
    private String password;
    private int balance;

    public CurrentAccount(String accountId,String password) {
        this.accountId = accountId;
        this.password=password;
    }

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

    Account getDetails(){
        return this;
    }

    @Override
    public boolean deposit(int amount) {
        this.balance=this.balance+amount;
        return true;
    }

    @Override
    public  boolean fetch(int amount) {
        if(this.balance>=amount) {
            this.balance = this.balance - amount;
            return true;
        }
        return false;
    }
}
