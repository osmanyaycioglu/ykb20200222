package com.training.micro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.models.Order;
import com.training.micro.services.PaymentService;

@RestController
@RequestMapping("/order")
public class OrderRest {

    @Autowired
    private PaymentService ps;

    @PostMapping("/place")
    public String placer(@RequestBody final Order order) {
        return this.ps.placeOrder(order);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
