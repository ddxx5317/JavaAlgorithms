package com.ddxx.study.algorithms.demo;

import java.util.Arrays;

/**
 * 加入一个布尔变量,如果内循环没有交换值,说明已经排序完成,提前终止
 */
public class Maopao2 {
    public static void main(String[] args) {
        int arr[] = {1, 8, 5, 3, 2, 4};
        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                boolean flag = true;
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // 调换
                        int temp;
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        flag = false;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

