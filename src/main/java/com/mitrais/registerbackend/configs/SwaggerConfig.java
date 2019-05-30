package com.mitrais.registerbackend.configs;

import com.mitrais.registerbackend.constants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:swagger.properties")
@ComponentScan("com.mitrais.registerbackend.controllers")
@EnableSwagger2
public class SwaggerConfig
{

    @Value("${swagger.apiinfo.version}")
    private String SWAGGER_API_VERSION;
    @Value("${swagger.apiinfo.license}")
    private String LICENSE_TEXT;
    @Value("${swagger.apiinfo.title}")
    private String TITLE;
    @Value("${swagger.apiinfo.description}")
    private String DESCRIPTION;


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .license(LICENSE_TEXT)
                .version(SWAGGER_API_VERSION).build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("MyCaseCollection")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(parameterList());
    }

    private List<Parameter> parameterList() {
        List<Parameter> result = new ArrayList<>();
        result.add(new ParameterBuilder().name(Constants.AUTHORIZATION)
                .description("token for api")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build());
        return result;
    }

}
