package com.kafka.Practice.BankManagement.Transaction;

import com.kafka.Practice.BankManagement.Account.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

public class TransactionService {
    private static final Logger log =
            LoggerFactory.getLogger(TransactionService.class);

    HistoryService historyService;
    TransactionService(HistoryService historyService){
        this.historyService=historyService;

    }
    static TransactionService instance;
    public static TransactionService getInstance(){
        if(instance==null){
            HistoryService historyService=new HistoryService();
            instance=new TransactionService(historyService);

        }
        return instance;

    }

    @Transactional
    public void transactMoney(Account sender, Account reciever, int amount){
        try{
            if(sender.getBalance()<amount){
                throw new Exception("Balance is low");
            }
            sender.fetch(amount);
            reciever.deposit(amount);
            log.info("Amount Rs.{} transferred from {} to {}",amount,sender.getAccountId(),reciever.getAccountId());
            addTransactionInHistory(amount,sender.getAccountId(),reciever.getAccountId());
        }
        catch(Exception e){
            log.error("Exception occurs {}",e.getMessage());
        }
    }

    @Async
    void addTransactionInHistory(int amount, String senderId,String receiverId){
        this.historyService.addTransactionInHistory(amount,senderId,receiverId);
    }
}
