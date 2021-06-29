package com.github.springquartz.config;

import com.github.springquartz.quartz.MyJob;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

// 配置 -> 数据库 -> quartz 访问数据库
@Configuration
public class QuartzConfig {

    // FactoryBean 的作用是 可简化 Bean 的实例化过程
    // 1. 通过 FactoryBean 封装了 Bean 的是实例化过程
    // 2. 将 FactoryBean 装配到 Spring 容器中
    // 3. 将 FactoryBean 注入给其他的 Bean
    // 4. 该 Bean 得到的是 FactoryBean 所管理的对象实例

    // 配置 JobDetail
    @Bean
    public JobDetailFactoryBean myJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(MyJob.class);
        factoryBean.setName("MyJob");
        factoryBean.setGroup("MyJobGroup");
        // 任务是否持久保存下去
        factoryBean.setDurability(true);
        // 任务是否是可恢复的
        factoryBean.setRequestsRecovery(true);
        return factoryBean;
    }

    // 配置 Trigger（SimpleTriggerFactoryBean,CronTriggerFactoryBean）
    @Bean
    public SimpleTriggerFactoryBean myTrigger(JobDetail myJobDetail){
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(myJobDetail);
        factoryBean.setName("MyTrigger");
        factoryBean.setGroup("MyTriggerGroup");
        // 执行任务的频率
        factoryBean.setRepeatInterval(3000);
        // 指定 JobDataMap 存储 Job 的状态
        factoryBean.setJobDataMap(new JobDataMap());
        return factoryBean;
    }
}
