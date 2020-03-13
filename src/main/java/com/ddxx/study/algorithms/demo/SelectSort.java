package com.ddxx.study.algorithms.demo;

import java.util.Arrays;

/**
 * 选择排序也是一种简单直观的排序算法，实现原理比较直观易懂：
 * 首先在未排序数列中找到最小元素，然后将其与数列的首部元素进行交换，
 * 然后，在剩余未排序元素中继续找出最小元素，将其与已排序数列的末尾位置元素交换。
 * 以此类推，直至所有元素圴排序完毕
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {1, 8, 5, 3, 2, 4};
        for(int i = 0; i < arr.length - 1 ; i++){
            int min = i; // 遍历的区间最小的值
            for (int j = i + 1; j < arr.length;j++){
                if(arr[j] < arr[min]){
                    // 找到当前遍历区间最小的值的索引
                    min = j;
                }
            }
            if(min != i){
                // 发生了调换
                int temp =  arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
