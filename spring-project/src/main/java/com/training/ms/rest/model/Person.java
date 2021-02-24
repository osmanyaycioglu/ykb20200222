package com.training.ms.rest.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.ms.validation.StartWith;

@XmlRootElement
@Entity
@Table(name = "kisi")
public class Person {

    @Id
    @GeneratedValue
    private Long      personId;

    @NotEmpty
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    private String    name;
    @NotEmpty
    @Size(min = 3, max = 30, message = "surname 3 ile 30 arasında olmalı")
    @StartWith(value = "test", message = "surname test ile başlamalı")
    private String    surname;
    @NotNull
    @Past
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    private EGender   gender;
    @Max(300)
    @Min(10)
    private Integer   weight;
    private Integer   length;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PersonExt personExt;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(final LocalDate birthdateParam) {
        this.birthdate = birthdateParam;
    }

    public EGender getGender() {
        return this.gender;
    }

    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
    }


    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    public Integer getLength() {
        return this.length;
    }

    public void setLength(final Integer lengthParam) {
        this.length = lengthParam;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", birthdate="
               + this.birthdate
               + ", gender="
               + this.gender
               + ", weight="
               + this.weight
               + ", length="
               + this.length
               + "]";
    }

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final Long personIdParam) {
        this.personId = personIdParam;
    }

    public PersonExt getPersonExt() {
        return this.personExt;
    }

    public void setPersonExt(final PersonExt personExtParam) {
        this.personExt = personExtParam;
    }


}
