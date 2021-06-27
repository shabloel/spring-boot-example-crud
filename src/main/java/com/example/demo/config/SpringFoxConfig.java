package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author : christiaan.griffioen
 * @since :  24-6-2021, do
 **/
@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {

   /* A docket is an object that contains all the customizable
    information that you want Swagger to show generation those
    documentations*/

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()//gets a Docket instance (ApiSelectorBuilder)
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfoBuilder()
                .title("Student Demo API")
                .version("1.0")
                .description("API for Practice")
                .contact(new Contact("Chris Griffioen", "http://chrisgriffioen.com", "xyz@email.com"))
                .license("Apache License Version 2.0")
                .build();
    }

}
