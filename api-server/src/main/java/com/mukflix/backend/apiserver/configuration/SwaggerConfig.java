package com.mukflix.backend.apiserver.configuration;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configurable
@EnableSwagger2
public class SwaggerConfig {
    @Bean

    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
//                .apiInfo(apiInfo());
    }
/*    private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("External Open Interface API Documentation")
                    .description("HTTP Open Interface")
                    .version("2.6.1")
                    .termsOfServiceUrl("http://localhost:8080/")
                    .build();
        }*/
}
