package com.thesis.accounts_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
 * @ComponentScans({@ComponentScan("com.thesis.accounts_microservice.controller")})
 * @EnableJpaRepositories("com.thesis.accounts_microservice.repository")
 * @EntityScan("com.thesis.accounts_microservice.models")
 */


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountsMicroserviceApplication.class, args);
	}
}
