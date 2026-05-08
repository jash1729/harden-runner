package com.poc.owasp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.poc.owasp")
@EnableJpaRepositories(basePackages = "com.poc.owasp")
public class OwaspApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwaspApplication.class, args);
	}

}
