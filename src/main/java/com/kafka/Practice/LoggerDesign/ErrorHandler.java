package com.kafka.Practice.LoggerDesign;

public class ErrorHandler extends Handler{

    @Override
    void print(String logLevel,String message) {
        if (logLevel.equals("error")) {
            System.out.println("ERROR " + message);
        }
        else{
            this.next.print(logLevel,message);
        }
    }
    void print(String logLevel,String message,String serviceName) {
        if (logLevel.equals("error")) {
            System.out.println("ERROR IS IN " +serviceName+" and message is "+ message);
        }
        else{
            this.next.print(logLevel,message);
        }
    }
}
