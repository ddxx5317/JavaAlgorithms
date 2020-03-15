package com.ddxx.study.algorithms.demo;

import java.util.Arrays;

/**
 * 数组倒序
 */
public class InvertArray {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i+1;
        }
        System.out.println(Arrays.toString(a));

        for (int j = 0; j < a.length; j++) {
            System.out.print(a[a.length-1-j] + "  ");
        }
        System.out.println("---------------------");
        for (int j = a.length-1; j >=0; j--) {
            System.out.print(a[j] + "  ");
        }
    }
}
