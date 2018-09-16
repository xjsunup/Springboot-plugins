package com.xj.plugins;

import com.xj.plugins.config.JerseySwaggerConfig;
import com.xj.plugins.config.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xuejian.sun on 2018/9/16.
 */
@Configuration
public class AppConfiguration {

    @Autowired
    private JerseyConfiguration jerseyConfiguration;

    @Autowired
    private SwaggerProperties swaggerProperties;

    @ConditionalOnProperty(
            name = "jersey.swagger.enable",
            havingValue = "true"
    )
    @ConditionalOnBean(JerseyConfiguration.class)
    @Bean
    public JerseySwaggerConfig jerseySwaggerConfig(){
        return new JerseySwaggerConfig(jerseyConfiguration,swaggerProperties);
    }
}
