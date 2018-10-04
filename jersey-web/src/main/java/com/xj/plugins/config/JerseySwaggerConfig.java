package com.xj.plugins.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.AcceptHeaderApiListingResource;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.Swagger;
import lombok.extern.slf4j.Slf4j;
import com.xj.plugins.JerseyConfiguration;

/**
 * Created by xuejian.sun on 2018/9/16.
 */
@Slf4j
public class JerseySwaggerConfig extends BeanConfig {

    private SwaggerProperties swaggerProperties;

    public JerseySwaggerConfig(JerseyConfiguration jerseyConfiguration
            , SwaggerProperties swaggerProperties) {
        log.info("swagger start initialize ....");
        this.swaggerProperties = swaggerProperties;
        jerseyConfiguration
                .register(ApiListingResource.class)
                .register(SwaggerSerializers.class)
                .register(AcceptHeaderApiListingResource.class);
        setConfigId("Spring Boot-jersey-swagger");
        setVersion(swaggerProperties.getVersion());
        setTitle(swaggerProperties.getTitle());
        setLicense("Apache 2.0");
        setLicenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html");
        setSchemes(new String[]{"http", "https"});
        setResourcePackage(swaggerProperties.getApiBasePackage());
        setBasePath("/api");
        setPrettyPrint(true);
        setScan(true);
    }

    @Override
    public Swagger getSwagger() {
        Info info = new Info()
                .contact(new Contact().email(swaggerProperties.getContactEmail())
                        .name(swaggerProperties.getAuthor())
                        .url(swaggerProperties.getCompanyUrl()))
                        .description(swaggerProperties.getDescription());
        Swagger swagger = new Swagger();
        swagger.setInfo(info);
        return swagger;
    }
}
