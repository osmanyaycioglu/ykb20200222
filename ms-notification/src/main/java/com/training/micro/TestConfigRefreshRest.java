package com.training.micro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RefreshScope
public class TestConfigRefreshRest {

    @Value("${a.b.c}")
    private String abc;

    @GetMapping("/config")
    public String test() {
        return this.abc;
    }

}
