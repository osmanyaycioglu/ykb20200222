package com.training.ms.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonExt {

    @Id
    @GeneratedValue
    private Long   peid;
    private String phoneNumber;
    private String taxNumber;

    public Long getPeid() {
        return this.peid;
    }

    public void setPeid(final Long peidParam) {
        this.peid = peidParam;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumberParam) {
        this.phoneNumber = phoneNumberParam;
    }

    public String getTaxNumber() {
        return this.taxNumber;
    }

    public void setTaxNumber(final String taxNumberParam) {
        this.taxNumber = taxNumberParam;
    }


}
