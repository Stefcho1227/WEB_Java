package org.example.inventorymanagersystemspring.config;

import org.example.inventorymanagersystemspring.service.logger.Logger;
import org.example.inventorymanagersystemspring.service.loggerEnum.LoggerLevel;
import org.example.inventorymanagersystemspring.service.loggerImpl.ConsoleLogger;
import org.example.inventorymanagersystemspring.service.loggerImpl.FileLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
    @Value("${config.logger.level:INFO}")
    private String level;
    @Bean
    @Profile("local")
    public Logger consoleLogger(){
        return new ConsoleLogger(LoggerLevel.valueOf(level));
    }
    @Bean
    @Profile("dev")
    public Logger fileLogger(){
        return new FileLogger(LoggerLevel.valueOf(level));
    }
}
