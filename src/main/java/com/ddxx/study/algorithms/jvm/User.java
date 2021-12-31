package com.ddxx.study.algorithms.jvm;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private int id;
    private String name;
    private long age;
    User(){}

    User(int id, String name,long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}