package com.training.ms.rest.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.ms.rest.model.Person;

public interface IPersonDao extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameIn(List<String> name);

    List<Person> findByNameOrderByName(String name);

    List<Person> findByNameAndSurname(String name,
                                      String surname);

    @Query("select p from Person p where p.name=:isim")
    List<Person> searchName(@Param("isim") String name);

    @Query(value = "select * from kisi k where k.name=:isim", nativeQuery = true)
    List<Person> searchNameNative(@Param("isim") String name);

}
