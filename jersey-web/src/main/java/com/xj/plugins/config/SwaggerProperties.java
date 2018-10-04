package com.xj.plugins.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuejian.sun
 * @date 2018/9/7
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "swagger2")
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerProperties {
    /**
     * 标题
     */
    private String title;
    /**
     * 说明
     */
    private String description;
    /**
     * 公司地址
     */
    private String companyUrl;
    /**
     * 联系方式一 , 号分割,例子(name,web_url,email)
     *                       (xx,www.baidu.com,xxx@email.com)
     */
    private String author;

    private String seeMoreAt;

    private String contactEmail;
    /**
     * 版本
     */
    private String version;
    /**
     * 对 xxx.xxx.xx包下的代码生成api文档
     */
    private String apiBasePackage;
}
