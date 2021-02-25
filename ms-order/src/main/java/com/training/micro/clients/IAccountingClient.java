package com.training.micro.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.micro.clients.error.RestException;
import com.training.micro.models.PaymentRequest;

@FeignClient("ACCOUNTING")
@RequestMapping("/api/v1/payment")
public interface IAccountingClient {

    @PostMapping("/pay")
    public String pay(@RequestBody final PaymentRequest pr) throws RestException;

}
