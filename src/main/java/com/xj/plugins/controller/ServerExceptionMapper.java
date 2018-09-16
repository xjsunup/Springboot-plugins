package com.xj.plugins.controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by xuejian.sun on 2018/9/16.
 */
@Provider
public class ServerExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        return Response.ok("异常全局处理："+e.getMessage(), MediaType.APPLICATION_JSON).build();
    }
}
