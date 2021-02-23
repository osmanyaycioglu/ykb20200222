package com.training.ms.wiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("es")
public class Execute3 implements IExecute {

    @Override
    public String execute(final String strParam) {
        return "Ola " + strParam;
    }

}
