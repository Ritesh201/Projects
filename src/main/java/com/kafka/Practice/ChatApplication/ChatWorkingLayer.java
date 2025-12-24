package com.kafka.Practice.ChatApplication;

import com.kafka.Practice.ChatApplication.Service.UserOperationService;
import com.kafka.Practice.ChatApplication.User.User;

public class ChatWorkingLayer {
    public static void start(){
        UserOperationService userOperationService=new UserOperationService();
        User user1=new User("ritesh_gupta","ritesh1234","active");
        User user2=new User("ritik_gupta","ritik1234","active");
        User user3=new User("ritik_goyal","ritik1234","active");
        userOperationService.addFollowing(user1,user2);
        System.out.println(user1);
        userOperationService.addFollowing(user1,user3);
        System.out.println(user1);
        userOperationService.removeFollowing(user1,user2);
        System.out.println(user1);
    }
}
