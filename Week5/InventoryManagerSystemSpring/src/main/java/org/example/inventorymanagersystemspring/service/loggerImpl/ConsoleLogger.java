package org.example.inventorymanagersystemspring.service.loggerImpl;

import org.example.inventorymanagersystemspring.service.loggerEnum.LoggerLevel;
import org.example.inventorymanagersystemspring.service.logger.Logger;

public class ConsoleLogger implements Logger {
    private LoggerLevel loggerLevel;
    public ConsoleLogger(LoggerLevel loggerLevel){
        this.loggerLevel = loggerLevel;
    }
    @Override
    public void info(Object toLog) {
        if(loggerLevel.getCode() >= LoggerLevel.INFO.getCode()){
            System.out.println("INFO " + toLog);
        }
    }

    @Override
    public void debug(Object toLog) {
        if(loggerLevel.getCode() >= LoggerLevel.DEBUG.getCode()){
            System.out.println("DEBUG " + toLog);
        }
    }

    @Override
    public void trace(Object toLog) {
        if(loggerLevel.getCode() >= LoggerLevel.TRACE.getCode()){
            System.out.println("TRACE " + toLog);
        }
    }

    @Override
    public void error(Object toLog) {
        if(loggerLevel.getCode() >= LoggerLevel.ERROR.getCode()){
            System.out.println("ERROR " + toLog);
        }
    }
}
