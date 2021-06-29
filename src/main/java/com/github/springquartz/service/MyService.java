package com.github.springquartz.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    // 被 @Async 注解注释的方法可以让该方法在多线程的环境下，被异步地调用
//    @Async
//    public void execute() {
//        System.out.println(Thread.currentThread().getName() + " execute");
//    }
//
//    @Scheduled(initialDelay = 1000,fixedRate = 1000)
//    public void execute2(){
//        System.out.println(Thread.currentThread().getName() + " execute");
//    }
}
