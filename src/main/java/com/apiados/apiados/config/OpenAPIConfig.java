package com.apiados.apiados.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI apiadosOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API Apiados - Impacto Urbano Positivo")
                .description("""
                        Esta API é o backend da plataforma **Apiados**.
                        
                        Aqui você encontra todos os endpoints para gerenciar o sistema de melhorias urbanas.
                        
                        **Funcionalidades:**
                        - 👤 **Usuários:** Cadastro, login e perfil.
                        - 🏙️ **Projetos:** Criação e listagem de demandas urbanas.
                        - ⭐ **Votos:** Sistema de votação para priorizar melhorias.
                        """)
                .version("1.0.0")
                .contact(new Contact()
                    .name("Equipe Apiados")
                    .url("https://github.com/MatheusV2021/POO-PIUP")
                    .email("contato@apiados.com"))
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://springdoc.org")));
    }
}