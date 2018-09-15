package com.xj.plugins.controller;

import com.xj.plugins.config.SwaggerProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author xuejian.sun
 * @date 2018/9/7
 */
@Api(description = "查询服务")
@Component
@Path("/query")
public class QueryController {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @ApiOperation(value = "查询用户",notes = "获取用户的信息")
    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public String query(@QueryParam ("id") @ApiParam(name="id",value = "用户编号",required = true) String id){
        return swaggerProperties.toString();
    }
}

