package com.javaboy.job;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : shmily
 * @GitHub : https://github.com/shmily0021
 * @Gitee : https://gitee.com/shmily0213
 * @createDate: 2023/5/23 8:42
 */
@Component
public class MyJob01 {

    public void sayHello() {
        System.out.println("MyJob01 : " + new Date());
    }
}
