package com.umb.taller.application;

import com.umb.taller.domain.exception.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionLogger {

    private static final Logger logger =
            LoggerFactory.getLogger(ExceptionLogger.class);

    public void log(AppException exception) {
        logger.error("Error de aplicación: {}", exception.getMessage(), exception);
    }
}
