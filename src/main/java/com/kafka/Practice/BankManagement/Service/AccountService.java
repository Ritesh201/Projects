package com.kafka.Practice.BankManagement.Service;

import com.kafka.Practice.BankManagement.Account.Account;

import java.util.HashMap;

public class AccountService {
    HashMap<String, Account> map=new HashMap<>();
    public Account login(String account,String password){
        if(map.containsKey(account) && map.get(account).getPassword().equals(password)){
            return map.get(account);
        }
        return null;
    }

    public void addAccount(Account account){
        map.put(account.getAccountId(), account);
    }
}
