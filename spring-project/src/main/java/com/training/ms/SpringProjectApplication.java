package com.training.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.ms",
//                                            "a.b.c"
//})
@SpringBootApplication
public class SpringProjectApplication {

    @Autowired
    MyClass class1;

    @Autowired
    MyClass class2;

    @Autowired
    MyClass class3;


}
