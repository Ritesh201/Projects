package com.kafka.Practice.LoggerDesign;

public class LogManager {
    private static Handler getLogManager(){
        Handler debug=new DebugHandler();
        Handler error=new ErrorHandler();
        Handler info=new InfoHandler();
        debug.setNext(error).setNext(info);
        return debug;
    }
    public static void main(String[] args){
        Handler handler=getLogManager();
        handler.print("info","information");
        handler.print("info","sky is blue","practice service");
        handler.print("error","red color");
        handler.print("debug","transferred from 1 to 2");

        handler.print("debug","transferred from 2 to 3");
    }
}
