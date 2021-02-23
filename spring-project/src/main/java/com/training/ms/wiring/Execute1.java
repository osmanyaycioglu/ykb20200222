package com.training.ms.wiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("eng")
public class Execute1 implements IExecute {

    @Override
    public String execute(final String strParam) {
        return "Hello " + strParam;
    }

}
