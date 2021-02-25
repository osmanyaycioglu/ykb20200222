package com.training.micro.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObject {

    private List<ErrorObject> subErrors;
    private String            boundedContext;
    private String            microservice;
    private String            errorDesc;
    private Integer           cause;


    public ErrorObject() {
    }

    public ErrorObject(final String errorDescParam,
                       final Integer causeParam) {
        super();
        this.errorDesc = errorDescParam;
        this.cause = causeParam;
    }


    public ErrorObject(final String boundedContextParam,
                       final String microserviceParam,
                       final String errorDescParam,
                       final Integer causeParam) {
        super();
        this.boundedContext = boundedContextParam;
        this.microservice = microserviceParam;
        this.errorDesc = errorDescParam;
        this.cause = causeParam;
    }

    public ErrorObject addSubError(final ErrorObject errorObjectParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjectParam);
        return this;
    }

    public List<ErrorObject> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObject setSubErrors(final List<ErrorObject> subErrorsParam) {
        this.subErrors = subErrorsParam;
        return this;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public ErrorObject setErrorDesc(final String errorDescParam) {
        this.errorDesc = errorDescParam;
        return this;
    }

    public Integer getCause() {
        return this.cause;
    }

    public ErrorObject setCause(final Integer causeParam) {
        this.cause = causeParam;
        return this;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public ErrorObject setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public ErrorObject setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }

    public static void main(final String[] args) {
        ErrorObject errorObjectLoc = new ErrorObject("xyz",
                                                     "abc",
                                                     "error",
                                                     100);

        errorObjectLoc = new ErrorObject().setBoundedContext("xyz")
                                          .setMicroservice("abc")
                                          .setErrorDesc("error")
                                          .setCause(100);
    }

}
