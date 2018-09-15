package com.xj.plugins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableSwagger2
@ComponentScan
@SpringBootApplication
public class Springboot2AnalyzeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2AnalyzeApplication.class, args);
    }
}
