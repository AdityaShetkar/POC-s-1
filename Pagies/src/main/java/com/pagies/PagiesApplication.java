package com.pagies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.pagies"})
public class PagiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagiesApplication.class, args);
    }

}
