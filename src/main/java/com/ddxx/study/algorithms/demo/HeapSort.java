package com.ddxx.study.algorithms.demo;

import java.util.Arrays;

/**
 * 堆排序
 * n个元素的数组
 * 由于堆存储在下标从0开始计数的数组中，因此，在堆中给定下标为i的结点时：
 * 如果 i = 0，结点 i 是根结点，无父结点；否则结点 i 的父结点为结点 [(i - 2) / 2] 向上取整
 * 如果 2i + 1 > n - 1，则结点 i 无左子女；否则结点 i 的左子女为结点 2i + 1
 * 如果 2i + 2 > n - 1，则结点 i 无右结点；否则结点 i 的右子女为结点 2i + 2
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {16, 7, 3, 20, 17, 8};
        heapSort(arr);
    }

    /**
     * 创建堆
     * @param arr 待排序列
     */
    private static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 调整堆
     * @param arr 待排序列
     * @param index 父节点
     * @param length 待排序列尾元素索引
     *
     */
    private static void adjustHeap(int[] arr, int index, int length) {
        //将temp作为父节点
        int temp = arr[index];

        //左孩子
        int lChild = 2 * index + 1;

        while (lChild < length) {//有左孩子
            //右孩子
            int rChild = lChild + 1;

            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            // 如果右孩子节点值大，则右节点值和父节点值比较
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;//左节点加1，表示右节点
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[index] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            //即每次调整都是从父节点、左孩子节点、右孩子节点三者中选择最大者跟父节点进行交换
            //(交换之后可能造成被交换的孩子节点不满足堆的性质，因此每次交换之后要重新对被交换的孩子节点进行调整)
            index = lChild;
            lChild = 2 * index + 1;
        }
        arr[index] = temp;
    }
}