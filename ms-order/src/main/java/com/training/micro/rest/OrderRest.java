package com.training.micro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.clients.error.RestException;
import com.training.micro.models.Order;
import com.training.micro.services.PaymentService;

@RestController
@RequestMapping("/order")
public class OrderRest {

    @Autowired
    private PaymentService ps;

    @Value("${server.port}")
    private int            port;

    @PostMapping("/place")
    public String place(@RequestBody final Order order) {
        return this.ps.placeOrder(order);
    }

    @PostMapping("/place2")
    public String place2(@RequestBody final Order order) throws RestException {
        return "order : " + this.port + " : " + this.ps.placeOrder2(order);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
