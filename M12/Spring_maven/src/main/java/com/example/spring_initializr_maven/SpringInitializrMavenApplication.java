package com.example.spring_initializr_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringInitializrMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringInitializrMavenApplication.class, args);
	}

}
