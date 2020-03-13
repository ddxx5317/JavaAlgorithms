package com.ddxx.study.algorithms.demo;

import java.util.Arrays;

/**
 * 两个有序数组的合并排序
 * 简单的思路就是先放到一个新的数组中、再排序、但是这样设计体现不了任何的算法
 * 这里考虑的不是快速排序算法、关键应该是利用已知条件
 * 思想：假设两个源数组的长度不一样、那么假设其中短的数组用完了、
 * 即全部放入到新的数组中去了、那么长数组总剩下的那一段就可以直接放到新数组中去了
 */
public class mergeArrays {
    public static void main(String[] args) {
        int[] arrA = {1,3,5,8};
        int[] arrB = {2,4,7};
        System.out.println(Arrays.toString(merge(arrA,arrB)));
    }
    private static int[] merge(int[] arrA, int[] arrB) {
        int lena = arrA.length;
        int lenb = arrB.length;
        int[] arrC = new int[lena+lenb];
        int i=0,j=0,k=0;//分别表示数组a、b、c的索引
        while (i < lena && j < lenb){
            if (arrA[i] < arrB[j]){
                arrC[k++] = arrA[i++];
            }else {
                arrC[k++] = arrB[j++];
            }
        }
        // 下面两个while表示，其中一个短数组已经复制完了，所有可能走其中while
        while (i<lena){
            arrC[k++] = arrA[i++];
        }
        while (j<lenb){
            arrC[k++] = arrB[j++];
        }
        return arrC;
    }
}
