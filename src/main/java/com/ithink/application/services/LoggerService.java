package com.ithink.application.services;

import com.ithink.application.port.in.LoggerPort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Logica de negocio para Loggers de la aplicacion
 * JB
 * */
public class LoggerService implements LoggerPort {

    private Logger logger;

    public void setLogger(Class<?> clazz) {
        this.logger = LogManager.getLogger(clazz);
    }

    @Override
    public void info(String message, Object... args) {
        logger.info(message, args);
    }

    @Override
    public void warn(String message, Object... args) {
        logger.warn(message, args);
    }

    @Override
    public void error(String message, Throwable throwable, Object... args) {
        logger.error(message, args, throwable);
    }

    @Override
    public void error(String message, Object... args) {
        logger.error(message, args);
    }
}
