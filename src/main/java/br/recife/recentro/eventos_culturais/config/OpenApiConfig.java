package br.recife.recentro.eventos_culturais.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API de Eventos Culturais", version = "v1", description = "Documentação da API de Eventos"))
public class OpenApiConfig {
}
