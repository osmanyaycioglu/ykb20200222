package com.training.ms.wiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CliRunner implements CommandLineRunner {

    @Autowired
    private Executor executor;

    @Override
    public void run(final String... argsParam) throws Exception {
        this.executor.executeMe("osman");
    }

}
