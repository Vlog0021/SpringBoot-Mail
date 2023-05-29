package com.javaboy.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author : shmily
 * @GitHub : https://github.com/shmily0021
 * @Gitee : https://gitee.com/shmily0213
 * @createDate: 2023/5/23 9:30
 */
@RestController
public class UserController {

    @ApiIgnore
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/user/{id}")
    // @ApiOperation(value = "查询用户", notes = "根据 id 查询用户") // Swagger2注解和他类似的Swagger3注解是@Operation
//    @ApiImplicitParam(paramType = "path", name = "id", value = "用户 id", required = true) // 参数描述 单个参数
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "用户 id", required = true), // 参数描述 多个参数
            @ApiImplicitParam(paramType = "path", name = "id", value = "用户 id", required = true), // 参数描述 多个参数
    })
    @ApiResponses({ // 状态码处理
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "500", description = "服务器错误")
    })
    public String getUserById(@PathVariable Integer id) {
        return "user : " + id;
    }
}
