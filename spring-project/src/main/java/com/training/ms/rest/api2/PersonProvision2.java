package com.training.ms.rest.api2;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ms.rest.api1.PersonQueryData;
import com.training.ms.rest.model.Person;
import com.training.ms.services.PersonManager;

@RestController
@RequestMapping("/api/v1/person/pro")
@Validated
public class PersonProvision2 {

    @Autowired
    private PersonManager pm;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person person) {
        this.pm.addOrUpdate(person);
        return "OK";
    }

    @GetMapping("/suspend")
    public String suspend(@NotNull @RequestParam("pid") final Long personId) {
        this.pm.delete(personId);
        return "OK";
    }

    @PostMapping("/change")
    public String update(@Validated @RequestBody final Person person) {
        this.pm.addOrUpdate(person);
        return "OK";
    }

    @GetMapping("/get")
    public Person get(@NotNull @RequestParam("pid") final Long personId) {
        return this.pm.get(personId);
    }

    @GetMapping("/search/by/name")
    public List<Person> get(@NotNull @RequestParam("name") final String name) {
        return this.pm.getByName(name);
    }

    @GetMapping("/getall")
    public List<Person> get() {
        return this.pm.getAll();
    }

    @GetMapping("/query")
    public Person query(@RequestBody final PersonQueryData person) {
        return null;
    }


}
