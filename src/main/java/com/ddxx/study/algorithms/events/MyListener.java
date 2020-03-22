package com.ddxx.study.algorithms.events;

import org.springframework.context.ApplicationListener;

public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("监听到Event事件: " + event.getMsg());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}