package com.kafka.Practice.NotificationSystem;

public class Message {
    private User sender;
    private User reciever;
    private String message;

    public Message(User sender, User reciever, String message) {
        this.sender = sender;
        this.reciever = reciever;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getReciever() {
        return reciever;
    }

    public void setReciever(User reciever) {
        this.reciever = reciever;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
