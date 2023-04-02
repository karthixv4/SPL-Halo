package com.spl.league;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = { "com.spl.controller", "com.spl.service","com.spl.repository"})
@EnableMongoRepositories("com.spl.repository")
public class SplbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplbackendApplication.class, args);
	}

}
