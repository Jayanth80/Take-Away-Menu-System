package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = ("com.example.controllers"))
@EntityScan(basePackages = "com.example.model")  // Add this line
@EnableJpaRepositories(basePackages = "com.example.repository")
@ComponentScan(basePackages = {"com.example.service", "com.example.controllers", /* add other packages if necessary */})

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Application is now online");
	}

}
