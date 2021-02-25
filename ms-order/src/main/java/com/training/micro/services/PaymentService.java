package com.training.micro.services;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.micro.clients.IAccountingClient;
import com.training.micro.clients.error.RestException;
import com.training.micro.models.NotifyRequest;
import com.training.micro.models.Order;
import com.training.micro.models.PaymentRequest;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate      rt;

    @Autowired
    private RabbitTemplate    rabbit;

    @Autowired
    private EurekaClient      eurekaClient;

    @Autowired
    private IAccountingClient accountingClient;

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

    public String placeOrder2(final Order order) throws RestException {
        PaymentRequest requestLoc = new PaymentRequest();
        requestLoc.setAmount(100);
        requestLoc.setCustomerId(order.getCustomerId());
        requestLoc.setCustomerName(order.getCustomerName());
        String retValLoc = this.accountingClient.pay(requestLoc);

        NotifyRequest notifyRequestLoc = new NotifyRequest();
        notifyRequestLoc.setDest("37862386");
        notifyRequestLoc.setMessage("Siparişini alındı sayın : " + order.getCustomerName());

        this.rabbit.convertAndSend("sms-notify-ex",
                                   "sms-notify",
                                   notifyRequestLoc);

        System.out.println(retValLoc);
        return retValLoc;
    }

    public String placeOrder3(final Order order) {
        Application applicationLoc = this.eurekaClient.getApplication("ACCOUNTING");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        InstanceInfo ii = null;
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc);
            ii = instanceInfoLoc;
        }

        ii = this.eurekaClient.getNextServerFromEureka("ACCOUNTING",
                                                       false);

        PaymentRequest requestLoc = new PaymentRequest();
        requestLoc.setAmount(100);
        requestLoc.setCustomerId("1223");
        requestLoc.setCustomerName("osman");
        RestTemplate myRestTemplateLoc = new RestTemplate();
        String retValLoc = myRestTemplateLoc.postForObject("http://"
                                                           + ii.getIPAddr()
                                                           + ":"
                                                           + ii.getPort()
                                                           + "/api/v1/payment/pay",
                                                           requestLoc,
                                                           String.class);
        System.out.println(retValLoc);
        return retValLoc;

    }

}
