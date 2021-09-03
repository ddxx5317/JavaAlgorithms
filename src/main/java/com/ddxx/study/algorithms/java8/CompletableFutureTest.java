package com.ddxx.study.algorithms.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2021/7/9
 */
@Slf4j
public class CompletableFutureTest {
    public static void main(String[] args) {
        String orderId = "8888888888888";
        CompletableFuture.runAsync(()->{
            int i = 0;
            int result = 100;
            //result = result/i;
            System.out.println("result="+ result);
        }).thenRun(()->{
            System.out.println("处理成功、orderId="+orderId);
        }).exceptionally(e->{
            System.out.println("处理失败，orderId="+orderId);
            return null;
        });
    }
}
