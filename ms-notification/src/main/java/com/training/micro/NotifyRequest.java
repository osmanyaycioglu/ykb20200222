package com.training.micro;


public class NotifyRequest {

    private String message;
    private String dest;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    public String getDest() {
        return this.dest;
    }

    public void setDest(final String destParam) {
        this.dest = destParam;
    }

    @Override
    public String toString() {
        return "NotifyRequest [message=" + this.message + ", dest=" + this.dest + "]";
    }


}
