package ru.shefer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI lviOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("lvi REST API")
                .description("lvi test forum")
                .version("1.0"));
    }
}
