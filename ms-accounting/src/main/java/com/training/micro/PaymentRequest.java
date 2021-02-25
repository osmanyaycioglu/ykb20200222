package com.training.micro;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PaymentRequest {

    @NotEmpty
    @Size(min = 3, max = 20)
    private String customerName;
    @NotEmpty
    @Size(min = 6, max = 8)
    private String customerId;
    @Max(1000)
    @Min(10)
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
