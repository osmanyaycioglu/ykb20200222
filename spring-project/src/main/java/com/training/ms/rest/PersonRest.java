package com.training.ms.rest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ms.rest.model.AddReqRes;
import com.training.ms.rest.model.Person;

@RestController
@RequestMapping("/person/provision")
public class PersonRest {

    private static final Logger logger = LoggerFactory.getLogger(PersonRest.class);


    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person person) {
        if (PersonRest.logger.isInfoEnabled()) {
            PersonRest.logger.info("[PersonRest][add]-> " + person);
        }
        return "Person " + person.getName() + " added successfully.";
    }

    @PostMapping(value = "/add2",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public AddReqRes add2(@RequestBody final Person person) {

        if (PersonRest.logger.isInfoEnabled()) {
            PersonRest.logger.info("[PersonRest][add2]-> " + person);
        }
        return AddReqRes.generateSuccessRes(person,
                                            "Person " + person.getName() + " added successfully.");
    }

    @PostMapping(value = "/add3",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public ResponseEntity<Person> add3(@RequestBody final Person person,
                                       final HttpServletRequest hs) {

        if (PersonRest.logger.isInfoEnabled()) {
            PersonRest.logger.info("[PersonRest][add3]-> HttpServletRequest : " + hs);
            PersonRest.logger.info("[PersonRest][add2]-> " + person);
        }
        return ResponseEntity.status(220)
                             .header("test",
                                     "testMe")
                             .body(person);
    }

}
