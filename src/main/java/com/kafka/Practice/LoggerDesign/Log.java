package com.kafka.Practice.LoggerDesign;

public class Log {
    private String logLevel;
    private String message;
    private String serviceName;

    public Log(String logLevel, String message, String serviceName) {
        this.logLevel = logLevel;
        this.message = message;
        this.serviceName = serviceName;
    }

    public Log(String logLevel, String message) {
        this.logLevel = logLevel;
        this.message = message;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
}
