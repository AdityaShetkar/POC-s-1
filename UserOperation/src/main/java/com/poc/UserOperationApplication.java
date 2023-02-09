package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class UserOperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserOperationApplication.class, args);
        System.out.println("All Set..!");
    }

}
