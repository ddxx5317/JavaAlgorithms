package com.ddxx.study.algorithms.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 寻找和为给定数的两个数
 */
public class SumData {
        public static void main(String[] args) {
            int[] arr = {1,4,7,9,6,10,22};
            System.out.println(Arrays.toString(finPairs(arr,14)));
        }
        private static int[] finPairs(int[] arr, int target) {
            int[] result = {-1,-1};
            Map<Integer,Integer> intMap = new HashMap<>();
            for(int anArr : arr){
                if(intMap.containsKey(anArr)){
                    result[0] = intMap.get(anArr);
                    result[1] = anArr;
                    break;
                }
                intMap.put(target-anArr,anArr);
            }
            return result;
        }
}
