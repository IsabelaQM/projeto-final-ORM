package iftm.orm.emails.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
            .info(new Info()
                .title("Documentação da API sobre o Sistema de E-mails")
                .version("Version 1")
                .description("Esta documentação apresenta o endpoint " +
                "responsável pela funcionalidade de E-mails do sistema.")
                .termsOfService("http://mytersm.com")
                .license(new License()
                .name("Apache 2.0")
                .url("http://mylicences.com"))
        
        );
    }
    
}
