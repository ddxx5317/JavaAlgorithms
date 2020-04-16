package com.ddxx.study.algorithms;

import com.ddxx.study.algorithms.enums.TradeStatusEnum;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/4/16
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // 1.得到枚举类对象
        Class<?> clz = TradeStatusEnum.class;
        // 2.得到所有枚举常量
        Object[] objects = clz.getEnumConstants();
        Method getCode = clz.getMethod("getCode");
        Method getName = clz.getMethod("getDescription");
        Method values = clz.getMethod("values");
        for (Object obj : objects){
            // 3.调用对应方法，得到枚举常量中字段的值
            System.out.println(obj.toString());
            //System.out.println("code=" + values.invoke(obj)+ "; name=" + values.invoke(obj));
        }
    }
}
