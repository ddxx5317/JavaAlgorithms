package com.ddxx.study.algorithms.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 寻找和为给定数的两个数（有序）
 */
public class SumData2 {
        public static void main(String[] args) {
            int[] arr = {1,4,6,9,10,22};
            finPairs(arr,15);
        }
        private static void finPairs(int[] arr, int target) {
            int left = 0;
            int right = arr.length-1;
            while (right>left){
                int sum = arr[right]+arr[left];
                if(sum==target){
                    System.out.printf("%d %d \n",arr[right],arr[left]);
                    break;
                }else {
                    if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
}
