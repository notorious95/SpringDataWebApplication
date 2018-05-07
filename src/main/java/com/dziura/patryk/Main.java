package com.dziura.patryk;


import com.dziura.patryk.config.DatabaseConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Main class which is responsible for starting whole Application
 */
@Component
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
    }
}
