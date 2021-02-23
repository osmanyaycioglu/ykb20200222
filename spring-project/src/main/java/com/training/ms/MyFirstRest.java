package com.training.ms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/first")
public class MyFirstRest {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
