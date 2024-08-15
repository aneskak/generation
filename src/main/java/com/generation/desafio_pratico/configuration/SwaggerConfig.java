package com.generation.desafio_pratico.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.customizers.OpenApiCustomizer;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Aplicação para desafio online | Programação na prática - Generation")
                        .description("API CRUD desenvolvida por Aneska.")
                        .version("v.0.1")
                        .license(new License()
                                .name("Aneska Karina - Github")
                                .url("https://github.com/aneskak")))
                .externalDocs(new ExternalDocumentation()
                        .description("Aneska Karina - Linkedin")
                        .url("https://www.linkedin.com/in/aneska/"));
    }

    @Bean
    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser()
    {
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation ->
            {
                ApiResponses apiResponses = operation.getResponses();

                apiResponses.addApiResponse("200",createApiResponse("Sucesso!"));
                apiResponses.addApiResponse("201",createApiResponse("Objeto persistido."));
                apiResponses.addApiResponse("204",createApiResponse("Objeto excluído."));
                apiResponses.addApiResponse("400",createApiResponse("Erro na requisição."));
                apiResponses.addApiResponse("404",createApiResponse("Objeto não encontrado."));
                apiResponses.addApiResponse("500",createApiResponse("Erro na aplicação."));
            }));
        };
    }

    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }
}
