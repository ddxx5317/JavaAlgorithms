package com.ddxx.study.algorithms.demo;

/**
 * 分治法
 * 它的思想主要是通过一趟排序将待排记录分隔成独立的两部分，其中的一部分比关键字小，
 * 后面一部分比关键字大，然后再对这前后的两部分分别采用这种方式进行排序，
 * 通过递归的运算最终达到整个序列有序
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {1, 8, 5, 3, 2, 4};
        doQuickSort(arr,0,arr.length-1);
    }
    public static void doQuickSort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i < j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }
            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        //将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        doQuickSort(array, left, i - 1);
        doQuickSort(array, i + 1, right);
    }
}
