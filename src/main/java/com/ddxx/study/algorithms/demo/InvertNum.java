package com.ddxx.study.algorithms.demo;

/**
 * 整数反转
 * 例如：123 → 321
 */
public class InvertNum {
    public static void main(String[] args) {
        int num = 123;
        int result = 0;
        while (num != 0){
            result = result * 10 + num % 10;
            num = num / 10;
        }
        System.out.println(result);
    }
}