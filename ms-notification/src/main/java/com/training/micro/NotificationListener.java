package com.training.micro;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-notify-q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "sms-notify-ex",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "sms-notify"))
    @SendTo("sms-notify-response-ex/sms-notify-response")
    public String handleNotifyMessage(final NotifyRequest notifyRequestParam) {
        System.out.println("Received : " + notifyRequestParam);
        return "Processed successfully : " + notifyRequestParam;
    }

}
