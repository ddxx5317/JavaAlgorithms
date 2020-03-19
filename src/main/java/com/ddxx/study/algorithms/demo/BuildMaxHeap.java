package com.ddxx.study.algorithms.demo;

import java.util.Arrays;

/**
 * 给定一个数组、构建一个大堆
 * n个元素的数组
 * 由于堆存储在下标从0开始计数的数组中，因此，在堆中给定下标为i的结点时：
 * 如果 i = 0，结点 i 是根结点，无父结点；否则结点 i 的父结点为结点 [(i - 2) / 2] 向上取整
 * 如果 2i + 1 > n - 1，则结点 i 无左子女；否则结点 i 的左子女为结点 2i + 1
 * 如果 2i + 2 > n - 1，则结点 i 无右结点；否则结点 i 的右子女为结点 2i + 2
 */
public class BuildMaxHeap {
    public static void main(String[] args) {
        int[] arr = {16, 7, 3, 20, 17, 8};
        System.out.println(Arrays.toString(arr));
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            buildHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void buildHeap(int[] arr, int index, int length) {
        int temp = arr[index];
        int lChild = 2 * index +1;
        while (lChild < length){
            int rChild = lChild + 1;
            if(rChild < length && arr[lChild] < arr[rChild]){
                lChild++;
            }
            if (temp > arr[lChild]){
                break;
            }
            arr[index] = arr[lChild];
            index = lChild;
            lChild = 2 * index +1;
        }
        arr[index] = temp;
    }
}