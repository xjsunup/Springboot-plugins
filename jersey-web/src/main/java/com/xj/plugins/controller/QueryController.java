package com.xj.plugins.controller;

import com.xj.plugins.config.SwaggerProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xj.plugins.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author xuejian.sun
 * @date 2018/9/7
 */
@Api(basePath = "/query",description = "查询服务",value = "查询服务")
@Component
@Path("/query")
public class QueryController {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @ApiOperation(value = "GET查询",notes = "获取swagger配置信息")
    @GET
    @Path("/profile")
    @Produces(MediaType.TEXT_PLAIN)
    public String testGet(){
        return swaggerProperties.toString();
    }

    @ApiOperation(value = "Post查询",notes = "获取swagger配置信息")
    @POST
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public User testPost(@QueryParam ("id") @ApiParam(name="id",value = "用户编号",example = "any",required = true) String id){
        User.UserBuilder builder = User.builder();
        builder.age(13)
                .id(1)
                .name("swagger")
                .sex("man");
        return builder.build();
    }

    @ApiOperation(value = "异常处理测试",notes = "jersey 全局异常统一处理")
    @DELETE
    @Path("/exception")
    @Produces(MediaType.TEXT_PLAIN)
    public String testException(){
        if(true){
            throw new NullPointerException("异常处理测试。。。。。");
        }
        return "error";
    }
}

