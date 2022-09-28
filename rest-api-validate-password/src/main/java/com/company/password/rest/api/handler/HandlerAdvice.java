package com.company.password.rest.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class HandlerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(HandlerAdvice.class);

    @ExceptionHandler(value
            = { Exception.class })
    protected ResponseEntity<Object> handleInvalidBody(
            RuntimeException ex, WebRequest request) {
        LOG.error("Request validatePassword error request", ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }
}
