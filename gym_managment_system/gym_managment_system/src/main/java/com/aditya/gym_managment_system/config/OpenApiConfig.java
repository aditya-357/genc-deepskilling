package com.aditya.gym_managment_system.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI gymApiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gym Management System API")
                        .version("1.0")
                        .description("Backend REST API for managing gym members, plans, attendance, and payments"));
    }
}
