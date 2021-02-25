package com.training.micro.clients.error;


public class RestException extends Exception {

    private static final long serialVersionUID = 2313934439943845948L;

    private ErrorObject       errorObject;


    public RestException() {
    }

    public RestException(final ErrorObject errorObjectParam) {
        super();
        this.errorObject = errorObjectParam;
    }

    public ErrorObject getErrorObject() {
        return this.errorObject;
    }

    public void setErrorObject(final ErrorObject errorObjectParam) {
        this.errorObject = errorObjectParam;
    }


}
