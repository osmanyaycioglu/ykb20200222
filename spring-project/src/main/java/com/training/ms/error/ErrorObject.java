package com.training.ms.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObject {

    private List<ErrorObject> subErrors;
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

    public void addSubError(final ErrorObject errorObjectParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjectParam);
    }

    public List<ErrorObject> getSubErrors() {
        return this.subErrors;
    }

    public void setSubErrors(final List<ErrorObject> subErrorsParam) {
        this.subErrors = subErrorsParam;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public void setErrorDesc(final String errorDescParam) {
        this.errorDesc = errorDescParam;
    }

    public Integer getCause() {
        return this.cause;
    }

    public void setCause(final Integer causeParam) {
        this.cause = causeParam;
    }


}
