package com.training.ms.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddReqRes {

    private Integer status;
    private String  name;
    private String  surname;
    private String  desc;

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

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String descParam) {
        this.desc = descParam;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(final Integer statusParam) {
        this.status = statusParam;
    }

    public static AddReqRes generateSuccessRes(final Person person,
                                               final String desc) {
        AddReqRes addReqResLoc = new AddReqRes();
        addReqResLoc.setName(person.getName());
        addReqResLoc.setSurname(person.getSurname());
        addReqResLoc.setStatus(100);
        addReqResLoc.setDesc(desc);
        return addReqResLoc;
    }


}
