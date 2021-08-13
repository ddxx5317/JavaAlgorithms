package com.ddxx.study.algorithms.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2021/8/13
 */
public class StreamTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("dd",12,"北京大学"));
        users.add(new User("xx",33,"南京大学"));
        users.add(new User("king",54,"上海大学"));
        users.add(new User("dd",12,"四川大学"));
        System.out.println(StreamUtil.convert2List(users,User::getName));

    }
}
