package com.xj.plugins.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuejian.sun
 * @date 2018/9/7
 */
@RestController
@RequestMapping(value = "/user",produces="application/json;charset=UTF-8")
public class UserController {

    @DeleteMapping("id")
    public String remove(){
        return "ok";
    }
}
