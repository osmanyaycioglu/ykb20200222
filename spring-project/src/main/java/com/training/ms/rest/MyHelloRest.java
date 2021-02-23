package com.training.ms.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MyHelloRest {

    @GetMapping("/test1/{isim}/{soyisim}")
    public String hello1(@PathVariable("isim") final String name,
                         @PathVariable("soyisim") final String surname) {
        return "GET Hello1 " + name + " " + surname;
    }

    @GetMapping("/test2")
    public String hello2(@RequestParam("is") final String name,
                         @RequestParam("so") final String surname) {
        return "GET Hello2 " + name + " " + surname;
    }

    @GetMapping("/test3/{isim}")
    public String hello3(@PathVariable("isim") final String name,
                         @RequestParam("so") final String surname) {
        return "GET Hello3 " + name + " " + surname;
    }

    @GetMapping("/test4")
    public String hello4(@RequestHeader("isim") final String name,
                         @RequestHeader("soyisim") final String surname,
                         @RequestParam("yas") final Integer age) {
        return "GET Hello4 " + name + " " + surname + " " + age;
    }


}
