package com.pron.blfwt.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc //NOTE: Only needed in a non-springboot application
@EnableSwagger2
@ComponentScan("com.pron.blfwt.admin.controller")
public class SwaggerAdminConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SPRING_WEB)
            .select()
            .apis(RequestHandlerSelectors.any())
           /* .paths(regex("/api/.*"))*/
            .build()
            .pathMapping("")
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo( 
            "Admin REST API",
            "This is a description of Admin REST API.",
            "",
            "",
            "",
            "",
            ""
        );
        return apiInfo;
    }
}