package com.xj.plugins;

import com.xj.plugins.config.ServerRequestFilter;
import com.xj.plugins.config.ServerResponseFilter;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.AcceptHeaderApiListingResource;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by xuejian.sun on 2018/9/15.
 */
@Component
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        jerseySwaggerConfig();
        packages("com.xj.plugins.controller")
                .register(ApiListingResource.class)
                .register(SwaggerSerializers.class)
                .register(ServerRequestFilter.class)
                .register(ServerResponseFilter.class)
                .register(AcceptHeaderApiListingResource.class);

    }

    private void jerseySwaggerConfig() {
        BeanConfig config = new BeanConfig();
        config.setConfigId("springboot-jersey-swagger-example");
        config.setTitle("Spring Boot + Jersey + Swagger");
        config.setVersion("1.0");
        config.setContact("xuejian.sun");
        config.setSchemes(new String[]{"http", "https"});
        config.setResourcePackage("com.xj.plugins.controller");
        config.setPrettyPrint(true);
        config.setBasePath("/api");
        config.setScan(true);
    }
}
