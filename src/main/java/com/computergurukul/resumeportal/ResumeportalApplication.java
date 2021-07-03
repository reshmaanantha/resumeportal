package com.computergurukul.resumeportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ResumeportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeportalApplication.class, args);
	}

}
