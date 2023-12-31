package com.example.twitterBacked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class TwitterBackedApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterBackedApplication.class, args);
	}

}
