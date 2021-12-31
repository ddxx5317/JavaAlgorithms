package com.ddxx.study.algorithms.demo;

import java.util.concurrent.LinkedTransferQueue;

 

public class MultiThreadTest {

    private static LinkedTransferQueue linkedC = new LinkedTransferQueue();
    private static LinkedTransferQueue linkedN = new LinkedTransferQueue();
    public static void main(String[] args) {

        String c = "ABCDEFGHI";
        char[] ca = c.toCharArray();
        String n = "123456789";
        char[] na = n.toCharArray();

        Thread t1 = new Thread(() -> {
            for(char caa : ca) {
                try {
                    linkedC.put(caa);
                    char a = (char) linkedN.take();
                    System.out.print(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t001");

        Thread t2 = new Thread(() -> {
            for(char naa : na) {
                try {
                    char b = (char) linkedC.take();
                    System.out.print(b);
                    linkedN.put(naa);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t002");
        t1.start();
        t2.start();
    }
}
