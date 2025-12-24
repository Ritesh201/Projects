package com.kafka.Practice.BankManagement;

import com.kafka.Practice.BankManagement.Account.Account;
import com.kafka.Practice.BankManagement.Account.CurrentAccount;
import com.kafka.Practice.BankManagement.Account.SavingAccount;
import com.kafka.Practice.BankManagement.Service.AccountService;
import com.kafka.Practice.BankManagement.Transaction.HistoryService;
import com.kafka.Practice.BankManagement.Transaction.TransactionService;


public class BankManager {

    AccountService accountService;
    public BankManager(AccountService accountService){

        this.accountService=accountService;
    }
    public void mainn() throws Exception {
        requirements();
        Account account= this.accountService.login("account1","password1");
        Account account2= this.accountService.login("account2","password2");
        if(account==null){
            throw new Exception("Account not found");
        }
        System.out.println(account.deposit(100));
        transferMoney(account,account2,50);
        System.out.println(account.getBalance());
        System.out.println(account2.getBalance());

    }
    private  void requirements(){
        SavingAccount account1=new SavingAccount("account1","password1");
        CurrentAccount account2=new CurrentAccount("account2","password2");
        this.accountService.addAccount(account1);
        this.accountService.addAccount(account2);

    }
    void transferMoney(Account account1, Account account2, int amount){

        TransactionService transactionService=TransactionService.getInstance();
        transactionService.transactMoney(account1,account2,amount);
    }
}
