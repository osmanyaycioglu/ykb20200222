package com.training.ms.wiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import a.b.c.TestConfig;

@Configuration
@Profile("live")
@Import(TestConfig.class)
@PropertySource("classpath:my.properties")
@EnableScheduling
public class ExecuteConfigLive {

    @Scheduled(fixedDelay = 10_000)
    public void sc() {
        System.out.println("çalıştım");
    }

    @Value("${execute.type}")
    private Integer choice;

    @Value("#{myProps.getType()}")
    private Integer choice2;

    @Bean
    public Executor executor() {
        return new Executor("test ");
    }


    @Bean
    @Qualifier("dynamic")
    public IExecute genExecute(@Value("${execute.type}") final Integer choiceParam) {
        switch (choiceParam) {
            case 3:
                return new Execute1();
            case 1:
                return new Execute2();
            case 2:
                return new Execute3();
            default:
                return new Execute1();
        }
    }

    @Bean
    @Qualifier("another")
    public IExecute anotherExecute() {
        switch (this.choice2) {
            case 1:
                return new Execute1();
            case 2:
                return new Execute2();
            case 3:
                return new Execute3();
            default:
                return new Execute1();
        }
    }

    //    @Autowired
    //    private Environment env;
    //
    //    @Bean
    //    @Qualifier("dynamic")
    //    public IExecute genExecute() {
    //        Integer choice = Integer.parseInt(this.env.getProperty("execute.type"));
    //        switch (choice) {
    //            case 1:
    //                return new Execute1();
    //            case 2:
    //                return new Execute2();
    //            case 3:
    //                return new Execute3();
    //            default:
    //                return new Execute1();
    //        }
    //    }
}
