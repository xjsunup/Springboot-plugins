package com.xj.plugins.config;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

/**
 * Created by xuejian.sun on 2018/9/15.
 */
@Slf4j
public class ServerRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        log.info("do request {} from {}",context.getMethod(),context.getUriInfo().getPath());
    }
}
