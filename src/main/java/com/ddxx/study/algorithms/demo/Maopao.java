package com.ddxx.study.algorithms.demo;

import java.util.Arrays;

/**
 * 每次冒泡过程都是从数列的第一个元素开始，然后依次和剩余的元素进行比较，
 * 若小于相邻元素，则交换两者位置，同时将较大元素作为下一个比较的基准元素，
 * 继续将该元素与其相邻的元素进行比较，直到数列的最后一个元素
 */
public class Maopao {
    public static void main(String[] args) {
        int arr[] = {1,8, 5, 3, 2, 4};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
