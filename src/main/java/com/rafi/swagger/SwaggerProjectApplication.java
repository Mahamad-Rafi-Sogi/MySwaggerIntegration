package com.rafi.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@OpenAPIDefinition(info = @Info(title = "Rafi's Swagger API", version = "v1", description = "Swagger API Documentation"))
@SpringBootApplication
@EntityScan("com.rafi.swagger.entity")
@EnableJpaRepositories("com.rafi.swagger.repository")
public class SwaggerProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerProjectApplication.class, args);
    }
}