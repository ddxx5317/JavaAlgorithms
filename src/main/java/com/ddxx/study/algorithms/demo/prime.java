package com.ddxx.study.algorithms.demo;

/**
 * 找出n个数内所有质数
 */
public class prime {
    public static void main(String[] args) {
        for (int i=0;i<20 ;i++){
            if (isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }
    public static boolean isPrime(int num){
        for(int i=2;i<Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
