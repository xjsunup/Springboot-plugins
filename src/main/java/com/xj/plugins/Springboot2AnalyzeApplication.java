package com.xj.plugins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Springboot2AnalyzeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2AnalyzeApplication.class, args);
    }
}
