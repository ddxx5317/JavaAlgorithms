package com.ddxx.study.algorithms.jvm;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class JolTest {
    public static void main(String[] args) {
        User user = new User(1, "king",88L);
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println(GraphLayout.parseInstance(user).totalSize());
    }
}


