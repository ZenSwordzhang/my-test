package com.zsx.controller;

import com.zsx.service.IProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController("/msg")
public class MessageController {

    @Autowired
    private IProducer iProducer;

    @GetMapping("/{topic}/{msg}")
    public ResponseEntity<?> sendMsg(@PathVariable("topic") String topic, @PathVariable("msg") String msg) {
        iProducer.sendMessage(topic, msg);
        return ResponseEntity.ok().build();
    }
}
