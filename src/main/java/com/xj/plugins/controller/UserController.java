package com.xj.plugins.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuejian.sun
 * @date 2018/9/7
 */
@RequestMapping(value = "/user",produces="application/json;charset=UTF-8")
public class UserController {

    @ApiOperation(value = "查询用户",notes = "获取用户的信息")
    @DeleteMapping("id")
    public String remove(){
        return "ok";
    }
}
