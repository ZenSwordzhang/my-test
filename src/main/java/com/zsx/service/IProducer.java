package com.zsx.service;

public interface IProducer {

    void sendMessage(String topic, String content);
}
