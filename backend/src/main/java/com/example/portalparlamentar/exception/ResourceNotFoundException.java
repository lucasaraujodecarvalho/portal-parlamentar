package com.example.portalparlamentar.exception;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(ResourceNotFoundException.class);

    private String resourceType;

    public ResourceNotFoundException(String message) {
        super(message);
        logger.error(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        logger.error(message, cause);
    }

    public ResourceNotFoundException(String resourceType, String message) {
        super(message);
        this.resourceType = resourceType;
    }

}
