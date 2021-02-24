package com.training.ms.rest.api1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQuery {

    @PostMapping
    public String update(@RequestBody final PersonQueryData person) {
        return "OK";
    }

}
