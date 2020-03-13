package com.ddxx.study.algorithms.demo;

import org.springframework.aop.target.LazyInitTargetSource;

import java.util.*;

/**
 * 两个数组交集
 */
public class IntersectArray {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(new Integer[]{1,4,6,8,6});
        List<Integer> r = Arrays.asList(new Integer[]{2,4,6});

        List<Integer> resultLst = doIntersect(l,r);
        System.out.println(resultLst);
    }
    public static <T> List<T> doIntersect(List<T> leftList, List<T> rightList){
        Map<T,Integer> tempMap = new HashMap<>();
        for (T t : leftList) {
            if (tempMap.containsKey(t)){
                tempMap.put(t,tempMap.get(t)+1);
            }else {
                tempMap.put(t,1);
            }
        }

        List<T> resultList = new ArrayList<>();
        for (T t : rightList) {
            if (tempMap.containsKey(t)){
                resultList.add(t);
                tempMap.put(t,tempMap.get(t)-1);
                int count = tempMap.get(t);
                if (count <= 0){
                    tempMap.remove(t);
                }
            }
        }
        return resultList;
    }
}
