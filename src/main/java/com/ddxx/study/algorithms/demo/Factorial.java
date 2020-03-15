package com.ddxx.study.algorithms.demo;

/**
 * N以内阶乘
 */
public class Factorial {
    public static int getFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n*n + getFactorial(n - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(getFactorial(4));
    }
}

