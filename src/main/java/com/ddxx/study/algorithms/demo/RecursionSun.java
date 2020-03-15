package com.ddxx.study.algorithms.demo;

/**
 * 递归求一个数内的偶数和
 */
public class RecursionSun {
    public static int sum(int num) {
        if (num == 1){
            return 0;
        }else if(num == 2){
            return num;
        }else {
            return num + sum(num-2);
        }
    }
    public static void main(String[] args) {
        System.out.println(sum(8));
    }
}

