package com.ddxx.study.algorithms.demo;

/**
 * 寻找最大回文字符串
 * 一个字符串中存在的最大长度的回文字符串
 */
public class FindMaxHuiWen extends HuiWen {
    public static void main(String[] args) {
        String str = "aaabcbaabdedd";
        System.out.println(findPalindrome(str));
    }

    private static String findPalindrome(String str) {
        String result = null;
        String tempString = null;
        int max = 0;
        for (int i = 0;i < str.length();i++){
            for(int j = str.length();j > i;j--){
                tempString = str.substring(i,j-1);
                if(isPalindrome(tempString) && (j-i+1)>max){
                    max = j-i+1;
                    result = tempString;
                }
            }
        }
        return result;
    }
}
