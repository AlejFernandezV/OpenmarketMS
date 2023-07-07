package com.unicauca.openmarketms.Commons;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi customOpenAPI() {
        return GroupedOpenApi.builder()
                .group("apisbellacas") // Cambia el nombre del grupo de la API
                .addOpenApiCustomizer(api -> api.getInfo().setTitle("OpenMarketMS API's")) // Cambia el título aquí
                .build();
    }
}
