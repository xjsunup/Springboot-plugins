package com.xj.plugins;

import com.xj.plugins.config.ServerRequestFilter;
import com.xj.plugins.config.ServerResponseFilter;
import com.xj.plugins.controller.QueryController;
import com.xj.plugins.controller.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by xuejian.sun on 2018/9/15.
 */
@Component
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        this.register(QueryController.class)
                .register(UserController.class)
                .register(ServerRequestFilter.class)
                .register(ServerResponseFilter.class);
    }
}
