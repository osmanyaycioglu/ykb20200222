package com.training.micro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentRest {

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/pay")
    public String pay(final PaymentRequest pr) {
        System.out.println(pr);
        return "Payment success " + this.port;
    }

}
