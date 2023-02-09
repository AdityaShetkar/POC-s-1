package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableWebMvc
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
		System.err.println("\nREADY TO TEST");
	}

}
