package com.training.ms.rest.api1;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ms.rest.model.Person;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvision1 {

    @PutMapping
    public String add(@RequestBody final Person person) {
        return "OK";
    }

    @DeleteMapping
    public String suspend(@RequestBody final Person person) {
        return "OK";
    }

    @PostMapping
    public String update(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping("/search")
    public Person get(@RequestParam("pid") final Long personId) {
        return null;
    }

}
