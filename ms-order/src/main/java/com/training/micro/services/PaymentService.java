package com.training.micro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.micro.models.Order;
import com.training.micro.models.PaymentRequest;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate rt;

    public String placeOrder(final Order order) {
        PaymentRequest requestLoc = new PaymentRequest();
        requestLoc.setAmount(100);
        requestLoc.setCustomerId("1223");
        requestLoc.setCustomerName("osman");
        String retValLoc = this.rt.postForObject("http://ACCOUNTING/api/v1/payment/pay",
                                                 requestLoc,
                                                 String.class);
        System.out.println(retValLoc);
        return retValLoc;

    }

}
