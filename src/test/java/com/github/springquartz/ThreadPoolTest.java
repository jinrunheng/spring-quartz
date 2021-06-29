package com.github.springquartz;

import com.github.springquartz.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringQuartzApplication.class)
public class ThreadPoolTest {

    // JDK 线程池
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    // JDK 可执行定时任务的线程池
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    // Spring 普通线程池
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    // Spring 定时任务线程池
    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    private MyService service;

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExecutorService() {
        Runnable task = () -> System.out.println(Thread.currentThread().getName() + " ExecutorService");

        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
            sleep(1000);
        }
    }

    @Test
    public void testScheduledExecutorService() {
        Runnable task = () -> System.out.println(Thread.currentThread().getName() + " ScheduledExecutorService");
        scheduledExecutorService.scheduleAtFixedRate(task, 1000, 1000, TimeUnit.MILLISECONDS);
        sleep(300000);
    }

    @Test
    public void testThreadPoolTaskExecutor() {
        Runnable task = () -> System.out.println(Thread.currentThread().getName() + " ThreadPoolTaskExecutor");

        for (int i = 0; i < 10; i++) {
            taskExecutor.submit(task);
            sleep(1000);
        }
    }

    @Test
    public void testThreadPoolTaskScheduler() {
        Runnable task = () -> System.out.println(Thread.currentThread().getName() + " ThreadPoolTaskScheduler");
        Date startTime = new Date(System.currentTimeMillis() + 1000);
        taskScheduler.scheduleAtFixedRate(task, startTime, 1000);
        sleep(300000);
    }

    // @Async
//    @Test
//    public void testAsync() {
//        for (int i = 0; i < 10; i++) {
//            service.execute();
//            sleep(1000);
//        }
//    }

    // @Scheduled
//    @Test
//    public void testScheduled(){
//         sleep(300000);
//    }

}
