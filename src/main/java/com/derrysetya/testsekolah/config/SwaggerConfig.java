package com.derrysetya.testsekolah.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springDoc() {
        return new OpenAPI()
            .info(new Info()
                    .title("SEKOLAH REST API"))
            .externalDocs(new ExternalDocumentation()
                    .description("sekolah Web Services")
                    .url("http://localhost:9090"));
    }
    
}
