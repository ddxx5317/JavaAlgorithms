package com.ddxx.study.algorithms.controller;

import com.ddxx.study.algorithms.aop.MqTypeEnum;
import com.ddxx.study.algorithms.aop.RawDataProcess;
import com.ddxx.study.algorithms.events.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

//    @Autowired
//    private ApplicationEventPublisher publisher;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/sayHello.json")
    public String sayHello() {
        MyEvent event = new MyEvent(this, "发生了一件大事儿！");
        applicationContext.publishEvent(event);
        String result = "事件发布成功";
        System.out.println(result);
        return result;
    }

    @GetMapping("/aop")
    @RawDataProcess(mqTypeEnum = MqTypeEnum.INIT)
    public String aop() {
        String result = "aop success";
        System.out.println(result);
        return result;
    }
}