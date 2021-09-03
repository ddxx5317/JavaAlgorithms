package com.ddxx.study.algorithms.aop;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class JolTest {
    public static void main(String[] args) {
        User user = new User(1, "zhangsan8888888888",88L);
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println(GraphLayout.parseInstance(user).totalSize());
    }
}

class User {
    private int id;
    private String name;
    private long age;

    public User(int id, String name,long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
