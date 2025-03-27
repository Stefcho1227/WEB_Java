package org.example.inventorymanagersystemspring.service.loggerImpl;

import org.example.inventorymanagersystemspring.service.logger.Logger;
import org.example.inventorymanagersystemspring.service.loggerEnum.LoggerLevel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FileLogger implements Logger {
    private LoggerLevel loggerLevel;
    public FileLogger(LoggerLevel loggerLevel){
        this.loggerLevel = loggerLevel;
    }

    private void logInformation(Object toLog, LoggerLevel currentLoggerLevel) {
        File log = new File("log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(log, true))) {
            out.println(new Date() + " [" + currentLoggerLevel.getLabel() + "] - " + toLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void info(Object toLog) {
        if(loggerLevel.getCode() >= LoggerLevel.INFO.getCode()){
            logInformation(toLog, LoggerLevel.INFO);
        }
    }

    @Override
    public void debug(Object toLog) {
        if(loggerLevel.getCode() >= LoggerLevel.DEBUG.getCode()){
            logInformation(toLog, LoggerLevel.DEBUG);
        }
    }

    @Override
    public void trace(Object toLog) {
        if(loggerLevel.getCode() >= LoggerLevel.TRACE.getCode()){
            logInformation(toLog, LoggerLevel.TRACE);
        }
    }

    @Override
    public void error(Object toLog) {
        if(loggerLevel.getCode() >= LoggerLevel.ERROR.getCode()){
            logInformation(toLog, LoggerLevel.ERROR);
        }
    }
}
