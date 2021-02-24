package com.training.ms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ms.rest.db.IPersonDao;
import com.training.ms.rest.model.Person;

@Service
public class PersonManager {

    @Autowired
    private IPersonDao personDao;

    public void addOrUpdate(final Person personParam) {
        this.personDao.save(personParam);
    }

    public Person get(final Long personId) {
        return this.personDao.findById(personId)
                             .orElse(null);
    }

    public List<Person> getByName(final String nameStringParam) {
        return this.personDao.findByName(nameStringParam);
    }

    public void delete(final Long personId) {
        this.personDao.deleteById(personId);
    }

    public List<Person> getAll() {
        Iterable<Person> findAllLoc = this.personDao.findAll();
        List<Person> personsLoc = new ArrayList<>();
        for (Person personLoc : findAllLoc) {
            personsLoc.add(personLoc);
        }
        return personsLoc;
    }


}
