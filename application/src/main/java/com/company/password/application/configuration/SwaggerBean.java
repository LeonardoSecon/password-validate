package com.company.password.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerBean {

    @Bean
    public Docket swaggerApi1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("password-validate-1.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.password.rest.api"))
                .build()
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().version("1.0")
                .title("Password Validate API")
                .description("Password Validate API").build();
    }
}
