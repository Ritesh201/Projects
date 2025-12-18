package com.kafka.Practice.NotificationSystem;

import java.util.ArrayList;


public class User {
    final ArrayList<Message> sentMessages;
    final ArrayList<Message> recieveMessages;
    String name;

    User(String name){
        this.name=name;
        sentMessages=new ArrayList<>();
        recieveMessages=new ArrayList<>();
    }



}
