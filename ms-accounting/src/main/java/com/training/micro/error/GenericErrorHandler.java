package com.training.micro.error;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericErrorHandler {


    private static final Logger logger = LoggerFactory.getLogger(GenericErrorHandler.class);

    @Value("${app.bounded-context}")
    private String              boundedContext;

    @Value("${spring.application.name}")
    private String              microservice;

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleException(final IllegalArgumentException exp) {
        return new ErrorObject().setBoundedContext(this.boundedContext)
                                .setMicroservice(this.microservice)
                                .setErrorDesc(exp.getMessage())
                                .setCause(100);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleException(final IllegalStateException exp) {
        return new ErrorObject().setBoundedContext(this.boundedContext)
                                .setMicroservice(this.microservice)
                                .setErrorDesc(exp.getMessage())
                                .setCause(100);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleException(final MethodArgumentNotValidException exp) {
        ErrorObject errorObject = new ErrorObject().setBoundedContext(this.boundedContext)
                                                   .setMicroservice(this.microservice)
                                                   .setErrorDesc("Validation Error")
                                                   .setCause(800);

        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            errorObject.addSubError(new ErrorObject().setBoundedContext(this.boundedContext)
                                                     .setMicroservice(this.microservice)
                                                     .setErrorDesc(objectErrorLoc.toString())
                                                     .setCause(801));
        }
        return errorObject;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleException(final Exception exp) {
        GenericErrorHandler.logger.error("[GenericErrorHandler][handleException]-> *Error* : " + exp.getMessage(),
                                         exp);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new ErrorObject().setBoundedContext(this.boundedContext)
                                                    .setMicroservice(this.microservice)
                                                    .setErrorDesc(exp.getMessage())
                                                    .setCause(300));
    }

}
