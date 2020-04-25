//package com.zsx.config;
//
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.context.event.ApplicationStartedEvent;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.EventListener;
//
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//@AutoConfigureBefore(ConfigC.class)
//public class ConfigB {
//
//    public ConfigB() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(3);
//        System.out.println("ConfigB()");
//    }
//
//    @EventListener(ApplicationStartedEvent.class)
//    public void onApplicationStarted() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(3);
//        System.out.println("ConfigB.onApplicationStarted()");
//    }
//}
