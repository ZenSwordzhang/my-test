package com.zsx.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Message implements Serializable {

    private Long id;
    private String msg;
    private LocalDateTime sendTime;

}
