package com.training.micro.models;


public class PaymentRequest {

    private String customerName;
    private String customerId;
    private long   amount;

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final String customerIdParam) {
        this.customerId = customerIdParam;
    }

    public long getAmount() {
        return this.amount;
    }

    public void setAmount(final long amountParam) {
        this.amount = amountParam;
    }


    public String getCustomerName() {
        return this.customerName;
    }


    public void setCustomerName(final String customerNameParam) {
        this.customerName = customerNameParam;
    }

    @Override
    public String toString() {
        return "PaymentRequest [customerName="
               + this.customerName
               + ", customerId="
               + this.customerId
               + ", amount="
               + this.amount
               + "]";
    }


}
