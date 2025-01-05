package com.example.swagger.config;

import com.sun.security.jgss.AuthorizationDataEntry;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.web.filter.ForwardedHeaderFilter;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@OpenAPIDefinition(
        servers = {
                @Server(url = "http://localhost:${server.port}${server.servlet.context-path}",description = "Localhost"),
        },
        info = @io.swagger.v3.oas.annotations.info.Info(title = "Swagger API")
)
public class OpenAPiConfig {
        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI();

        }

}
