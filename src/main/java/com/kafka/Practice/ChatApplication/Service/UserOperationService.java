package com.kafka.Practice.ChatApplication.Service;

import com.kafka.Practice.ChatApplication.User.User;

public class UserOperationService {

    public void addFollowing(User user1, User user2) {
        user1.getFollowing().add(user2);
    }

    public void removeFollowing(User user1, User user2) {
        user1.getFollowing().remove(user2);
    }
}
