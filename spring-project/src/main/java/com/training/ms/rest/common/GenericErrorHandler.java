package com.training.ms.rest.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.ms.error.ErrorObject;

@RestControllerAdvice
public class GenericErrorHandler {


    private static final Logger logger = LoggerFactory.getLogger(GenericErrorHandler.class);


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleException(final IllegalArgumentException exp) {
        return new ErrorObject(exp.getMessage(),
                               100);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleException(final IllegalStateException exp) {
        return new ErrorObject(exp.getMessage(),
                               200);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleException(final MethodArgumentNotValidException exp) {
        ErrorObject errorObject = new ErrorObject("Validation Error",
                                                  800);
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            errorObject.addSubError(new ErrorObject(objectErrorLoc.toString(),
                                                    801));
        }
        return errorObject;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleException(final Exception exp) {
        GenericErrorHandler.logger.error("[GenericErrorHandler][handleException]-> *Error* : " + exp.getMessage(),
                                         exp);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new ErrorObject(exp.getMessage(),
                                                   300));
    }

}
