package com.ddxx.study.algorithms.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * abcbab → a:2,b:3,c:1
 * 1:c,2:a,3:b
 */
public class Test {
    public static void main(String[] args) {
        String str ="abcbab";
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        System.out.println(map);
        Map<Character, Integer> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> result.put(x.getKey(),x.getValue()));
        System.out.println(result);
    }
}
