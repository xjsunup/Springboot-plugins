package com.xj.plugins;

import com.xj.plugins.config.ServerRequestFilter;
import com.xj.plugins.config.ServerResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by xuejian.sun on 2018/9/15.
 */
@Component
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        packages("com.xj.plugins.controller")
                .register(ServerRequestFilter.class)
                .register(ServerResponseFilter.class);

    }
}
