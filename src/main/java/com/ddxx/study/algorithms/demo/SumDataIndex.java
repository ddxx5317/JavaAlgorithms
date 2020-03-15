package com.ddxx.study.algorithms.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 寻找和为给定数的两个数在数组中的位置
 */
public class SumDataIndex {
        public static void main(String[] args) {
            int[] nums = {1,4,7,9,6,10,22};
            System.out.println(Arrays.toString(finPairs(nums,14)));
        }
        private static int[] finPairs(int[] nums, int target) {
            int[] result = {-1,-1};
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    result[0] = map.get(target - nums[i]);
                    result[1] = i;
                }
                map.put(nums[i], i);
            }
            return result;
        }
}
