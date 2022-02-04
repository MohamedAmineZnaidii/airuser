package com.challenger.airuser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created By ZNAIDI :)
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String CONTROLLER_PACKAGE="com.challenger.airuser.controllers.v1";

    /**
     * Configure Swagger APIs Documentation
     * @return APIs Documentation
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());
    }

    /**
     * Configure API information
     * @return Api information
     */
    private ApiInfo metaData(){

        Contact contact = new Contact("Mohamed Amine ZNAIDI", "",
                "znaidimohamedamine@gmail.com");

        return new ApiInfo(
                "Air User",
                "User registration API",
                "1.0",
                "",
                contact,
                "",
                "",
                new ArrayList<>());
    }
}
