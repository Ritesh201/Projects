package com.kafka.Practice.LoggerDesign;

public class InfoHandler extends Handler{


    void print(Log log) {
        if (log.getLogLevel().equals("info")) {
            if(log.getServiceName()!=null){
                System.out.println("INFO IS IN " +log.getServiceName()+" and message is "+ log.getMessage());
            }
            else{
                System.out.println("INFO " + log.getMessage());
            }

        }
        else{
            this.next.print(log);
        }
    }

}