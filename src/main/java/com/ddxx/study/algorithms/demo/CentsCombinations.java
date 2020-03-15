package com.ddxx.study.algorithms.demo;

/**
 * 1角硬币、2角硬币、5角硬币、问有多少种组合得到一块钱
 */
public class CentsCombinations {
    public static void main(String[] args) {
        int total = 0;
        System.out.println("1cents" + "  2cents" + "  5cents");
        for (int i = 0; i <= 10 ; i++) {
            for (int j = 0; j <=5 ; j++) {
                for (int k = 0; k <= 2; k++) {
                    total = i * 1 + j *2 + k * 5;
                    if (total > 10){
                        break;
                    }
                    if (total == 10){
                        System.out.println(i+ " "+j+" "+k);
                    }
                }
            }

        }
    }
}
