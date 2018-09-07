package com.xj.plugins.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuejian.sun
 * @date 2018/9/7
 */
@Api(description = "查询服务")
@RestController
@RequestMapping(value="/query",produces="application/json;charset=UTF-8")
public class QueryController {

    @ApiOperation(value = "查询用户",notes = "获取用户的信息")
    @GetMapping(value = "user")
    public String query(@RequestParam @ApiParam(name="id",value = "用户编号",required = true) String id){
        return "小米";
    }

    @PostMapping("/a")
    public String test(){
        return "";
    }
}

