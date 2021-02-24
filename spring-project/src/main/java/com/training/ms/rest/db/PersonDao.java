package com.training.ms.rest.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.training.ms.rest.model.Person;

@Repository
public class PersonDao {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    public void add(final Person personParam) {
        EntityManager cemLoc = this.entityManagerFactory.createEntityManager();
        cemLoc.joinTransaction();
        cemLoc.persist(personParam);
    }
}
