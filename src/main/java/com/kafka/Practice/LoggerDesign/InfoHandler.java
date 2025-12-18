package com.kafka.Practice.LoggerDesign;

public class InfoHandler extends Handler{


    void print(String logLevel,String message) {
        if (logLevel.equals("info")) {
            System.out.println("INFO " + message);
        }
        else{
            this.next.print(logLevel,message);
        }
    }

    void print(String logLevel,String message,String serviceName) {
        if (logLevel.equals("info")) {
            System.out.println("INFO IS IN " +serviceName+" and message is "+ message);
        }
        else{
            this.next.print(logLevel,message);
        }
    }
}