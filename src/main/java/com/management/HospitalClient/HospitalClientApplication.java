package com.management.HospitalClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HospitalClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalClientApplication.class, args);
	}

}
