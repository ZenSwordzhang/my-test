package com.zsx.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsx.entity.Message;
import com.zsx.service.IProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class KafkaProducer implements IProducer {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Override
    public void sendMessage(String topic, String content) {
        try {
            log.info("kafka sendMessage start");
            Message message = new Message();
            message.setId(UUID.randomUUID().toString());
            message.setSendTime(LocalDateTime.now());
            message.setContent(content);
            ObjectMapper mapper = new ObjectMapper();
            String jsonMsg = mapper.writeValueAsString(message);
            ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, jsonMsg);
            future.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onFailure(Throwable ex) {
                    log.error("kafka sendMessage error, ex = {}, topic = {}, data = {}", ex, topic, jsonMsg);
                }

                @Override
                public void onSuccess(SendResult<Integer, String> result) {
                    log.info("kafka sendMessage success topic = {}, data = {}", topic, jsonMsg);
                }
            });
            log.info("kafka sendMessage end");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
