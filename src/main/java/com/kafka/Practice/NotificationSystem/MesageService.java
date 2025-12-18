package com.kafka.Practice.NotificationSystem;

import java.util.List;

public class MesageService {

    static MesageService instance;
    static synchronized MesageService getInstance(){
        if(instance==null){
            instance=new MesageService();
        }
        return instance;
    }
    void sentMessage( User sender,User receiver,String text){
        Message message=new Message(sender,receiver,text);
        sender.sentMessages.add(message);
        receiver.recieveMessages.add(message);
    }
    void sentMessage(User sender, List<User> receivers, String text){
        for(User receiver:receivers) {
            sentMessage(sender, receiver, text);
        }
    }
}
