//package com.zsx.config;
//
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.context.event.ApplicationStartedEvent;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.EventListener;
//
//@Configuration
//@AutoConfigureAfter(ConfigC.class)
//public class ConfigA {
//
//    public ConfigA() {
//        System.out.println("ConfigA()");
//    }
//
//    @EventListener(ApplicationStartedEvent.class)
//    public void onApplicationStarted() {
//        System.out.println("ConfigA.onApplicationStarted()");
//    }
//}
