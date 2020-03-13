package com.ddxx.study.algorithms.demo;

import java.util.Arrays;

/**
 *  一次插入排序的操作过程：
 *  将待插元素，依次与已排序好的子数列元素从后到前进行比较，
 *  如果当前元素值比待插元素值大，则将移位到与其相邻的后一个位置，
 *  否则直接将待插元素插入当前元素相邻的后一位置，
 *  因为说明已经找到插入点的最终位置
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {1, 8, 5, 3, 2, 4};
        for(int i = 1; i < arr.length; i++) {
            //挖出一个要用来插入的值,同时位置上留下一个可以存新的值的坑
            int x = arr[i];
            int j = i - 1;
            //在前面有一个或连续多个值比x大的时候,一直循环往前面找,将x插入到这串值前面
            while (j >= 0 && arr[j] > x) {
                //当arr[j]比x大的时候,将j向后移一位,正好填到坑中
                arr[j + 1] = arr[j];
                j--;
            }
            //将x插入到最前面
            arr[j + 1] = x;
        }
        System.out.println(Arrays.toString(arr));
    }
}
