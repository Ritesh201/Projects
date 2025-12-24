package com.kafka.Practice.LoggerDesign;

public class ErrorHandler extends Handler{

    @Override
    void print(Log log) {
        if (log.getLogLevel().equals("error")) {
            if(log.getServiceName()!=null){
                System.out.println("ERROR IS IN " +log.getServiceName()+" and message is "+ log.getMessage());
            }
            else{
                System.out.println("ERROR " + log.getMessage());
            }

        }
        else{
            this.next.print(log);
        }
    }

}
