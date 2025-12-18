package com.kafka.Practice.LoggerDesign;

public class LogManager {
    private static Handler getLogManager(){
        Handler debug=new DebugHandler();
        Handler error=new ErrorHandler();
        Handler info=new InfoHandler();
        error.setNext(debug).setNext(info);
        return error;
    }
    public static void main(String[] args){
        Handler handler=getLogManager();
        handler.print(new Log("info","information"));
        handler.print(new Log("info","sky is blue","practice service"));
        handler.print(new Log("error","red color"));
        handler.print(new Log("debug","transferred from 1 to 2"));

        handler.print(new Log("debug","transferred from 2 to 3"));
    }
}
