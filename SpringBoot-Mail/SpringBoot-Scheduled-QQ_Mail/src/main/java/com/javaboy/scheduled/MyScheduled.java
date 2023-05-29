package com.javaboy.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : shmily
 * @GitHub : https://github.com/shmily0021
 * @Gitee : https://gitee.com/shmily0213
 * @createDate: 2023/5/22 19:59
 */
@Component
public class MyScheduled {

    @Scheduled(fixedDelay = 1000) // 当前方法执行结束之后一秒后执行下一个任务
    public void fixedDelay() {
        System.out.println("fixedDelay : " + new Date());
    }

    @Scheduled(fixedRate = 1000) // 当前方法执行1秒后就开始执行下一个任务
    public void fixedRate() {
        System.out.println("fixedRate : " + new Date());
    }

    @Scheduled(initialDelay = 1000) // 项目执行1秒后执行
    public void initDelay() {
        System.out.println("initDelay : " + new Date());
    }

    @Scheduled(cron = "0/5 * * * * *") // 搭配cron表达式执行
    public void cron() {
        System.out.println("cron : " + new Date());
    }
}
