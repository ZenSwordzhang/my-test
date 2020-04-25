//package com.zsx.config;
//
//import org.springframework.boot.context.event.ApplicationStartedEvent;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.EventListener;
//
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//public class ConfigC {
//
//    public ConfigC() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("ConfigC()");
//    }
//
//    @EventListener(ApplicationStartedEvent.class)
//    public void onApplicationStarted() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("ConfigC.onApplicationStarted()");
//    }
//}
