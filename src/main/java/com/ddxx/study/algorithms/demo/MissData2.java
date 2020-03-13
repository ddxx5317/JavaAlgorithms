package com.ddxx.study.algorithms.demo;

/**
 * 求missed number、寻找丢失的那个数
 * 有一数组如 int[]{0,1,2} 这样的一个数组、这个数组的第一个必须从0开始，依次+1列出
 * 该数组内最后一个数是这个数组的长度
 * int[]{1,2}、missed number 为0
 * int[]{0,1,2}、missed number 为3
 * int[]{0,2}、missed number 为1
 */
public class MissData2 {
    public static void main(String[] args) {
        int arr[] = {0,1,3};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int total = (arr.length+1) * arr.length / 2;
        System.out.println(total - sum);
    }
}
