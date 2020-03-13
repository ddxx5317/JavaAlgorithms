package com.ddxx.study.algorithms.demo;

/**
 * 从才对出行的一组数据内，寻找一个丢失的
 * 例如,2,2,3,3,4里面少了一个4。
 */
public class MissData {
    public static void main(String[] args) {
        int arr[] = {2, 2, 3, 3, 4, 5, 6, 5, 4};
        int result = 0;
        for(int i = 0;i<arr.length;i++){
            result ^= arr[i];
        }
        System.out.println(result);
    }
}
