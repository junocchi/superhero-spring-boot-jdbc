package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com")

public class SuperheroJdbcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperheroJdbcProjectApplication.class, args);
	}

}
