package com.xj.plugins.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel
public class User {
    @ApiModelProperty(value = "用户编号")
    private long id;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "年龄")
    private int age;
}