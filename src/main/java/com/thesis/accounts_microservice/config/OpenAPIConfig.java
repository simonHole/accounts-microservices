package com.thesis.accounts_microservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("Accounts microservice REST API documentation")
                .version("v1")
                        .description("Thesis Project Accounts Microservice REST API documentation")
                        .contact(new Contact()
                                .name("Szymon Dziura")
                                .email("181714@stud.prz.edu.pl"))
                        .license(new License()
                                .name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Thesis Project Accounts Microservice REST API documentation")
                        .url("https://github.com/simonHole/accounts-microservices"));

    }
}
