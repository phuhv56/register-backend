package com.mitrais.registerbackend.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler
{
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
}
