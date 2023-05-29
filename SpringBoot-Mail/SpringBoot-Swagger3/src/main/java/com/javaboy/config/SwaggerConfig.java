package com.javaboy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author : shmily
 * @GitHub : https://github.com/shmily0021
 * @Gitee : https://gitee.com/shmily0213
 * @createDate: 2023/5/23 9:35
 */
@Configuration
public class SwaggerConfig {

    @Bean
    Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .select() // 指定那些接口需要生成文档
                .apis(RequestHandlerSelectors.basePackage("com.javaboy.controller")) // 指定生成文档的接口在哪里
                .paths(PathSelectors.any()) // 都要生成
                .build()
                .apiInfo( // 关于文档网站的配置
                        new ApiInfoBuilder()
                                .description("项目接口文档") // 网站描述
                                .contact(new Contact("javaboy", "http://www.shmily.live", "shmily0021@yeah.net"))
                                .version("v1.0") // 版本
                                .title("API 测试文档")
                                .license("Apache 2.0")
                                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                                .build()
                );
    }
}
