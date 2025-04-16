package com.example.portalparlamentar.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExternalApiException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(ExternalApiException.class);

    public ExternalApiException(String message) {
        super(message);
        logger.error(message);
    }

}
