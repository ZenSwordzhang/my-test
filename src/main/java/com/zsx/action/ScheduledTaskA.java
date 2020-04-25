//package com.zsx.action;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
//@Component
//@Slf4j
//public class ScheduledTaskA {
//
//
//    /**
//     * {秒数:0~59} {分钟:0~59} {小时:0~23}
//     * {日期:1~31} {月份:1~12} {星期:1~7}
//     */
//    @Scheduled(cron = "0/3 * * * * ?")
//    public void runA() throws InterruptedException {
//        log.info(Thread.currentThread().getName() + " AAA Start");
//        TimeUnit.SECONDS.sleep(5);
//        log.info(Thread.currentThread().getName() + " AAA End");
//    }
//
//    @Scheduled(initialDelay=1000, fixedRate=2000)
//    public void runB() throws InterruptedException {
//        log.info(Thread.currentThread().getName() + " BBB Start");
//        TimeUnit.SECONDS.sleep(5);
//        log.info(Thread.currentThread().getName() + " BBB End");
//    }
//
//    @Scheduled(initialDelay=1000, fixedDelay = 2000)
//    public void runC() throws InterruptedException {
//        log.info(Thread.currentThread().getName() + " CCC Start");
//        TimeUnit.SECONDS.sleep(5);
//        log.info(Thread.currentThread().getName() + " CCC End");
//    }
//}
