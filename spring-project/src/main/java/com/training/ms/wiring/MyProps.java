package com.training.ms.wiring;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "execute")
public class MyProps {

    private Integer      type;
    private String       str;
    private List<String> names;


    public Integer getType() {
        return this.type;
    }

    public void setType(final Integer typeParam) {
        this.type = typeParam;
    }

    public String getStr() {
        return this.str;
    }

    public void setStr(final String strParam) {
        this.str = strParam;
    }

    public List<String> getNames() {
        return this.names;
    }

    public void setNames(final List<String> namesParam) {
        this.names = namesParam;
    }
}
