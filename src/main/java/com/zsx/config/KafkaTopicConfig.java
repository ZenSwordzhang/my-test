package com.zsx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka.topic")
public class KafkaTopicConfig {

    private String groupId;
    private String[] topicName;
}
