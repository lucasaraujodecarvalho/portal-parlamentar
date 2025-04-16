package com.example.portalparlamentar.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NegocioException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(NegocioException.class);

    public NegocioException(String message) {
        super(message);
        logger.error(message);
    }

    public NegocioException(String message, Throwable cause) {
        super(message, cause);
        logger.error(message, cause);
    }

}
