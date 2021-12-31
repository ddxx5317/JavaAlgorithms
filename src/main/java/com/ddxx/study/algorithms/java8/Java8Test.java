package com.ddxx.study.algorithms.java8;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java8常用Api
 */
public class Java8Test {
    public static void main(String[] args) {
        // 初始化list
        List<String> list = Stream.of("a","b","c").collect(Collectors.toList());
        System.out.println(list);

        list = Stream.of("a","b","c").map(str -> str.toUpperCase()).collect(Collectors.toList());
        System.out.println(list);

        //list = Stream.of("a","b","c").filter(str -> isDigit(str.charAt(0))).collect(Collectors.toList());
        //System.out.println(list);

        List<Integer> together = Stream. of(Arrays.asList( 1, 2), Arrays.asList( 3, 4))
                .flatMap(numbers -> numbers.stream()) .collect(Collectors.toList());
        System.out.println(together);

        List<User> users = Arrays.asList(new User("张三", 44), new User("李四", 22), new User("王五", 33));
        User user = users.stream().min(Comparator.comparing(u -> u.getAge())).get();
        System.out.println(user);

        user = users.stream().max(Comparator.comparing(u -> u.getAge())).get();
        System.out.println(user);


        int num = Stream.of(1,3,4).reduce(0,(sum,i) -> sum+i);
        System.out.println(num);

       List<String> schools = Arrays.asList(new User("张三", 44,"华中科技大学"),
                new User("李四", 22,"北京大学"),
                new User("王五", 33,"清华大学"),
                new User("王六", 55,"西北大学"))
                .stream()
                .filter(u -> u.getName().startsWith("王"))
                .map(u -> u.getSchool()).collect(Collectors.toList());
        System.out.println(schools);

        IntSummaryStatistics summaryStatistics = Arrays.asList(new User("张三", 44,"华中科技大学"),
                new User("李四", 22,"北京大学"),
                new User("王五", 33,"清华大学"),
                new User("王六", 55,"西北大学"))
                .stream().mapToInt(u -> u.getAge()).summaryStatistics();
        System.out.println(summaryStatistics);


        // 求平均
        double avrAge = Arrays.asList(new User("张三", 44,"华中科技大学"),
                new User("李四", 22,"北京大学"),
                new User("王五", 33,"清华大学"),
                new User("王六", 55,"西北大学"))
                .stream().collect(Collectors.averagingInt(u -> u.getAge()));
        System.out.println(avrAge);

        //数据分片
        Map<Boolean, List<User>> result = Arrays.asList(
                new User("张三", 44,"华中科技大学"),
                new User("李四", 16,"北京大学"),
                new User("王五", 33,"清华大学"),
                new User("王六", 16,"西北大学"))
                .stream().collect(Collectors.partitioningBy(User :: isOldUser));
        System.out.println(result);

        //分组
        Map<Object,List<User>> mapResult = Arrays.asList(
                new User("张三", 44,"华中科技大学"),
                new User("李四", 16,"北京大学"),
                new User("王五", 33,"清华大学"),
                new User("王六", 16,"西北大学"))
                .stream().collect(Collectors.groupingBy(u -> u.getAge()));
        System.out.println(mapResult);


        String strResult = Arrays.asList(
                new User("张三", 44,"华中科技大学"),
                new User("李四", 16,"北京大学"),
                new User("王五", 33,"清华大学"),
                new User("王六", 16,"西北大学"))
                .stream().map(User :: getName).collect(Collectors.joining(", ","[","]"));
        System.out.println(strResult);


        //并行求和
        List<Integer> intList = Arrays.asList(1,2,3);
        int sumResult = intList.parallelStream().mapToInt(i -> i).sum();
        int sumResult1 = intList.stream().reduce(0,(sum,n) -> sum + n);
        System.out.println(sumResult);
        System.out.println(sumResult1);


        String packages = null;
        final String[] split = Optional.ofNullable(packages).orElse("").split(",");
        final List<String> strings = Lists.newArrayList(split);
        System.out.println(strings);
        System.out.println("------------------");

        final List<User> sortedUsers = Arrays.asList(new User("张三", 44, "华中科技大学"),
                        new User("李四", 16, "北京大学"),
                        new User("王五", 33, "清华大学"),
                        new User("王六", 10, "西北大学"))
                .stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());

        final User maxUser = Arrays.asList(new User("张三", 44, "华中科技大学"),
                        new User("李四", 16, "北京大学"),
                        new User("王五", 33, "清华大学"),
                        new User("王六", 10, "西北大学"))
                .stream().max(Comparator.comparing(User::getAge)).get();
        sortedUsers.stream().forEach(System.out::println);
        System.out.println("------------------");
        System.out.println(maxUser);


        final long count = Arrays.asList(new User("张三", 44, "华中科技大学"),
                        new User("李四", 16, "北京大学"),
                        new User("王六", 10, "西北大学"))
                .stream().count();
        System.out.println("count="+count);
    }
}
