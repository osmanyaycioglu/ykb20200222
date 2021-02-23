package com.training.ms.wiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import a.b.c.TestBean;

public class Executor {

    @Autowired
    @Qualifier("dynamic")
    private IExecute     exec;
    private final String prefix;

    @Autowired
    private TestBean     testBean;


    public Executor(final String prefix) {
        this.prefix = prefix;
    }

    public void executeMe(final String str) {
        this.testBean.test();
        System.out.println(this.prefix + this.exec.execute(str));
    }

}
