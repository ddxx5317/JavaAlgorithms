package com.ddxx.study.algorithms.java8;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/4/11
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, ListContainer> map = null;
        List<User> aClassList1 = Lists.newArrayList();
        User aClass = new User("name1", 11, "school1");
        aClassList1.add(aClass);
        aClassList1.add(new User("name2", 22, "school1"));
        aClassList1.add(new User("name3", 33, "school1"));

        List<User> aClassList2 = Lists.newArrayList();
        aClassList2.add(aClass);
        aClassList2.add(new User("name4", 44, "school1"));
        aClassList2.add(new User("name5", 55, "school1"));

        /*交集*/
        /*[AClass(id=1, name=zhuoli1, description=haha1)]*/
        List<User> intersectResult = aClassList1.stream().filter(aClassList2::contains).collect(Collectors.toList());
        System.out.println(intersectResult);

        /*并集*/
        List<User> unionResult = Stream.of(aClassList1, aClassList2).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        System.out.println(unionResult);

        /*差集*/
        /*[AClass(id=2, name=zhuoli2, description=haha2), AClass(id=3, name=zhuoli3, description=haha3)]*/
        List<User> differenceResult = aClassList1.stream().filter(x -> !aClassList2.contains(x)).collect(Collectors.toList());
        System.out.println(differenceResult);

        map.put(1, new ListContainer(aClassList1));
        map.put(2, new ListContainer(aClassList2));

        /*合并多个list*/
    }
}
