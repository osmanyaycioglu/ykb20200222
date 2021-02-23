package com.training.ms.wiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tr")
public class Execute2 implements IExecute {

    @Override
    public String execute(final String strParam) {
        return "Merhaba " + strParam;
    }

}
