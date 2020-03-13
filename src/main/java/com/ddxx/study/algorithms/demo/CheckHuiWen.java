package com.ddxx.study.algorithms.demo;

/**
 * 判断是否为回文字符串
 * 例如：abcba
 * 分析：使用两个指针、分别从字符串头部和尾部扫描
 * 若每个指针所指的值相等、则为回文字符串。
 */
public class CheckHuiWen extends  HuiWen{
    public static void main(String[] args) {
        String str = "abcba";
        System.out.println(isPalindrome(str));
    }
}
