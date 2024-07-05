package it.syncroweb.template.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI caseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Template")
                        .description("API")
                        .version("1.0")
                );
    }

}
