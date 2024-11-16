package com.example.NewExamDemoProj1.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.info.License;
import springfox.documentation.swagger2.mappers.LicenseMapper;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Exam Ninja API")
                        .description("API documentation for the Exam Ninja application")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Exam Ninja Documentation")
                        .url("https://exam-ninja.docs"));
    }
}
