package com.kafka.Practice.LoggerDesign;

public abstract class Handler {
    public Handler next;
    public Handler setNext(Handler next){
        this.next=next;
        return next;
    }

    abstract void print(String logLevel,String message) ;
    abstract void print(String logLevel,String message,String serviceName) ;
}
