package com.example.chapter1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()            // ⾃自⾏行行修改为⾃自⼰己的包路路径
               .apis(RequestHandlerSelectors.basePackage("com.example.chapter1"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("客户管理理")
                .description("客户管理理中⼼心 API 1.0 操作⽂文档")            //服务条款⽹网址
                 .termsOfServiceUrl("http://www.ityouknow.com/")
                .version("1.0")
                .contact(new Contact("纯洁的微笑", "http://www.ityouknow.com/", "ityoukn ow@126.com"))
                .build();
    }
    }
