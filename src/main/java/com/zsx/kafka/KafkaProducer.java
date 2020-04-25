package com.zsx.kafka;

import com.zsx.service.IProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
public class KafkaProducer implements IProducer {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Override
    public void sendMessage(String topic, String msg) {
        log.info("kafka sendMessage start");

        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, msg);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("kafka sendMessage error, ex = {}, topic = {}, data = {}", ex, topic, msg);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                log.info("kafka sendMessage success topic = {}, data = {}", topic, msg);
            }
        });
        log.info("kafka sendMessage end");
    }
}
