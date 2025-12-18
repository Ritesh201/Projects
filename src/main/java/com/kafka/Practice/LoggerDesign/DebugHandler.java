package com.kafka.Practice.LoggerDesign;

public class DebugHandler extends Handler{

    @Override
    void print(String logLevel,String message) {
        if (logLevel.equals("debug")) {
            System.out.println("DEBUG " + message);
        }
        else{
            this.next.print(logLevel,message);
        }
    }
    void print(String logLevel,String message,String serviceName) {
        if (logLevel.equals("debug")) {
            System.out.println("DEBUG IS IN " +serviceName+" and message is "+ message);
        }
        else{
            this.next.print(logLevel,message);
        }
    }
}

