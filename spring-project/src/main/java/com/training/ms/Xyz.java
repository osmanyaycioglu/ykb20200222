
package com.training.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Xyz {

    public static void main(final String[] args) {
        ConfigurableApplicationContext runLoc = SpringApplication.run(SpringProjectApplication.class,
                                                                      args);
        SpringProjectApplication beanLoc = runLoc.getBean(SpringProjectApplication.class);
        MyClass beanLoc2 = (MyClass) runLoc.getBean("myClass");
        beanLoc.class1.setName("Mehmet");

        System.out.println(beanLoc.class3.getName());

        //        SpringProjectApplication applicationLoc = new SpringProjectApplication();
        //        applicationLoc.class1.setName("Mehmet");

    }


}
