package com.zsx.entity;

import com.zsx.action.ISing;
import lombok.Getter;

import java.io.Serializable;

public class User implements ISing, Serializable {

    @Getter
    public boolean singer;

}
