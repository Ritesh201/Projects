package com.kafka.Practice.NotificationSystem;

import java.util.ArrayList;
import java.util.Arrays;

public class NotificationSystem {
    public void notifySystem(){
        User user1=new User("ram");
        User user2=new User("shyam");
        User user3=new User("ghanshyam");
        MesageService mesageService=MesageService.getInstance();
        mesageService.sentMessage(user1,user2,"Hi , Iam ram");
        mesageService.sentMessage(user2,new ArrayList<>(Arrays.asList(user1,user3)),"Hi , Iam shyam");
    }
}
