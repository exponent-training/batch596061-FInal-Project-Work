package com.FinMediNexus.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Auth & PlanMaster APIs").version("1.0"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .name("Authorization")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        ));
    }
    
    
    
    @Bean
    public OpenApiCustomiser bearerTokenPrefixCustomizer() {
        return openApi -> openApi.getComponents().getSecuritySchemes()
                .forEach((name, scheme) -> {
                    if ("bearerAuth".equals(name)) {
                        scheme.setDescription("Enter JWT token only. 'Bearer ' prefix will be added automatically.");
                    }
                });
    }
}

