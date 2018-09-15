//package com.xj.plugins.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @author xuejian.sun
// * @date 2018/4/19
// */
//@ConditionalOnBean(annotation = EnableSwagger2.class)
//@Configuration
//@EnableConfigurationProperties(SwaggerProperties.class)
//public class Swagger2Configuration {
//
//    @Autowired
//    private SwaggerProperties swaggerProperties;
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getApiBasePackage()))
//                .paths(PathSelectors.any())
//                .build();
////                .globalOperationParameters(setHeaderToken());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title(swaggerProperties.getTitle())
//                .description(generateDescription())
//                .termsOfServiceUrl("")
//                .contact(new Contact(swaggerProperties.getAuthor(),
//                        swaggerProperties.getSeeMoreAt(),
//                        swaggerProperties.getContactEmail()))
//                .version(swaggerProperties.getVersion())
//                .build();
//    }
//
//    public String generateDescription(){
//        StringBuilder builder = new StringBuilder();
//        builder.append(swaggerProperties.getDescription());
//        builder.append("\n\r公司官网:"+swaggerProperties.getCompanyUrl());
//        return builder.toString();
//    }
//
////    private List<Parameter> setHeaderToken() {
////        ParameterBuilder tokenPar = new ParameterBuilder();
////        List<Parameter> pars = new ArrayList<>();
////        tokenPar.name("Authorization").description("token").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
////        pars.add(tokenPar.build());
////        return pars;
////    }
//}
