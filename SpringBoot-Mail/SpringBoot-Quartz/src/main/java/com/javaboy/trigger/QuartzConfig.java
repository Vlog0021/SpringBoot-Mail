package com.javaboy.trigger;

import com.javaboy.job.MyJob02;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

/**
 * @author : shmily
 * @GitHub : https://github.com/shmily0021
 * @Gitee : https://gitee.com/shmily0213
 * @createDate: 2023/5/23 8:47
 */
@Configuration
public class QuartzConfig {

    @Bean
    MethodInvokingJobDetailFactoryBean jobDetailOne() {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("myJob01");
        bean.setTargetMethod("sayHello");

        return bean;
    }

    @Bean
    JobDetailFactoryBean jobDetailFactoryBeanTwo() {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(MyJob02.class);
        JobDataMap map = new JobDataMap();
        map.put("name", "javaboy");
        bean.setJobDataMap(map);

        return bean;
    }

    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setJobDetail(jobDetailOne().getObject()); // 触发器对应的任务
        bean.setRepeatCount(3); // 重复次数
        bean.setStartDelay(1000); // 延迟
        bean.setRepeatInterval(1000); // 间隔一秒打印一次

        return bean;
    }

    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(jobDetailFactoryBeanTwo().getObject());
        bean.setCronExpression("0/5 * * * * ?");
        return bean;
    }

    @Bean // 启动器
    SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(simpleTriggerFactoryBean().getObject(), cronTriggerFactoryBean().getObject());
        return bean;
    }
}
