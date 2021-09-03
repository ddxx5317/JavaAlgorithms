package com.ddxx.study.algorithms.demo;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/9/27
 */
public class Print2 {
    static final Object object = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (object){
                for (int i = 1; i < 10; i += 2) {
                    System.out.println(Thread.currentThread().getName() + "->" + "A");
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1").start();

        new Thread(()->{
            synchronized (object){
                for (int i = 2; i < 10; i += 2) {
                    System.out.println(Thread.currentThread().getName() + "->" + "B");
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t2").start();
    }
}
