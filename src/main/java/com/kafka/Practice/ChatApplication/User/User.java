package com.kafka.Practice.ChatApplication.User;

import java.util.ArrayList;

public class User {
    private String userId;
    private String password;
    private String status ;
    private ArrayList<User> followers;
    private ArrayList<User> following;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }

    public User(String userId, String password, String status) {
        this.userId = userId;
        this.password = password;
        this.status = status;
        this.followers=new ArrayList<>();
        this.following=new ArrayList<>();

    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
