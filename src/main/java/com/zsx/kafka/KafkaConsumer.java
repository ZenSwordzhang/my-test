package com.zsx.kafka;

import com.zsx.config.KafkaTopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @Autowired
    private KafkaTopicConfig kafkaTopicConfig;

    @Bean
    private String[] kafkaTopicName() {
        return kafkaTopicConfig.getTopicName();
    }

    @Bean
    private String topicGroupId() {
        return kafkaTopicConfig.getGroupId();
    }


    @KafkaListener(topics = "#{kafkaTopicName}", groupId = "#{topicGroupId}")
    public void processMessage(ConsumerRecord<Integer, String> record) {
        log.info("kafka processMessage start");
        log.info("processMessage, topic = {}, msg = {}", record.topic(), record.value());
        // do something ...

        log.info("kafka processMessage end");
    }

}
