package com.mrclaudee.librarymanagmentapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API De Gestion De Livre")
                        .version("1.0")
                        .description("API De Gestion De Livre, réalisée en Java/Spring Boot + Swagger")
                        .contact(new Contact()
                                .name("Claude FOTSO")
                                .email("cfotsok@gmail.com")
                        )
                );
    }
}
