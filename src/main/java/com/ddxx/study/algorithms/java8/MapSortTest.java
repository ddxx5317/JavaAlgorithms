package com.ddxx.study.algorithms.java8;
 
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapSortTest {
	
	public static void main(String[] args) {  
		Map<String, Integer> unSortMap = new HashMap<>();
		unSortMap.put("z", 10);
		unSortMap.put("b", 5);
		unSortMap.put("a", 6);
		unSortMap.put("c", 20);

		System.out.println("Original...");
		System.out.println(unSortMap);

		Map<String, Integer> result = sortMapByValue(unSortMap);

		System.out.println("Sorted...");
		System.out.println(result);
    }
	
	public static Map<String, Integer> sortMapByKey(Map<String, Integer> unSortMap){
		Map<String, Integer> result = new LinkedHashMap<>();
		//sort by key, a,b,c..., and put it into the "result" map
		unSortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        return result;
	}
	
	public static Map<String, Integer> sortMapByValue(Map<String, Integer> unSortMap){
		Map<String, Integer> result = new LinkedHashMap<>();
		//sort by value, and reserve, 10,9,8,7,6...
		unSortMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())  // reversed倒序，不指定类型，会默认为<java.util.Map.Entry<java.lang.Object,V>>
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        return result;
	}
 
}
