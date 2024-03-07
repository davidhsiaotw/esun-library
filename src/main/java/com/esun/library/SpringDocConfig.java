package com.esun.library;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI baseOpenApi() {
        return new OpenAPI().info(
                new Info().title("玉山圖書 API")
                        .description("Those API manages the data of books, users and records").version("v0.0")
        );
    }
}
