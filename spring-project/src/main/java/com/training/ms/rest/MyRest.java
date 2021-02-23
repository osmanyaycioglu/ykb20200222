package com.training.ms.rest;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@Validated
public class MyRest {

    @GetMapping("/hello/{isim}/{soyisim}")
    public String hello1(@NotNull @PathVariable("isim") final String name,
                         @NotNull @PathVariable("soyisim") final String surname) {
        return "GET Hello1 " + name + " " + surname;
    }

    @PostMapping("/hello/{isim}/{soyisim}")
    public String hello2(@PathVariable("isim") final String name,
                         @PathVariable("soyisim") final String surname) {
        return "POST Hello2 " + name + " " + surname;
    }

    @PutMapping("/hello/{isim}/{soyisim}")
    public String hello3(@PathVariable("isim") final String name,
                         @PathVariable("soyisim") final String surname) {
        return "PUT Hello3 " + name + " " + surname;
    }

    @PatchMapping("/hello/{isim}/{soyisim}")
    public String hello4(@PathVariable("isim") final String name,
                         @PathVariable("soyisim") final String surname) {
        return "PATCH Hello4 " + name + " " + surname;
    }

    @DeleteMapping("/hello/{isim}/{soyisim}")
    public String hello5(@PathVariable("isim") final String name,
                         @PathVariable("soyisim") final String surname) {
        return "DELETE Hello5 " + name + " " + surname;
    }

}
