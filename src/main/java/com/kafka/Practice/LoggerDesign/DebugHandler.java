package com.kafka.Practice.LoggerDesign;

public class DebugHandler extends Handler{

    @Override
    void print(Log log) {
        if (log.getLogLevel().equals("debug")) {
            if(log.getServiceName()!=null){
                System.out.println("DEBUG IS IN " +log.getServiceName()+" and message is "+ log.getMessage());
            }
            else{
                System.out.println("DEBUG " + log.getMessage());
            }

        }
        else{
            this.next.print(log);
        }
    }
}

