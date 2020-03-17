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
    public static int partition(int[] array,int low,int high){
        int base = array[low];
        while(low < high){
            while(array[high] >= base && high > low){
                high--;
            }
            array[low] = array[high];
            while(array[low] <= base && high > low){
                low++;
            }
            array[high] = array[low];
        }

        // 此时low=high、所以array[low] = array[low] = base，即返回low和high结果一样;
        array[low] = base;
        return low;
    }

    public static void doQuickSort(int[] array,int low ,int high){
        if(low >= high){
            return;
        }
        int index = partition(array,low,high);
        doQuickSort(array,low,index-1);
        doQuickSort(array,index+1,high);
    }
}
