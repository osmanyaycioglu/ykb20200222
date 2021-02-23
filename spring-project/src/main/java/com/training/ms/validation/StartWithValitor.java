package com.training.ms.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValitor implements ConstraintValidator<StartWith, String> {

    private StartWith ano;


    @Override
    public void initialize(final StartWith a) {
        this.ano = a;

    }


    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.ano.value());
    }

}
