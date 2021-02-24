package com.training.micro.models;

import java.util.List;

public class Order {

    private String       orderName;
    private String       customerName;
    private String       customerId;
    private List<String> meals;

    public String getOrderName() {
        return this.orderName;
    }

    public void setOrderName(final String orderNameParam) {
        this.orderName = orderNameParam;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(final String customerNameParam) {
        this.customerName = customerNameParam;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final String customerIdParam) {
        this.customerId = customerIdParam;
    }

    public List<String> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<String> mealsParam) {
        this.meals = mealsParam;
    }


}
