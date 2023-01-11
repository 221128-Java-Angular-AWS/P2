package com.revature.Squawk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages =
				"com.revature.Squawk.controllers, " +
				"com.revature.Squawk.services," +
				"com.revature.Squawk.repositories")

public class SquawkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquawkApplication.class, args);
	}

}
