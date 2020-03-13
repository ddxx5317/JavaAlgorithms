package com.ddxx.study.algorithms.demo;

/**
 * 约瑟夫环算法
 * 假设20个人手拉手围城一圈、顺时针开始报数，报到3的人出圈，然后继续往后报数，报到3的人出圈
 * 一次把所有报到3的人都出圈，最后剩下一人也踢出圈
 * 问先后被踢出圈的那些人原来是圈内几号？
 */
public class JosephCircle {
    public void josephCircle(int n,int k){
        int flag = 0;

        //初始化一个数组，表示是否出圈
        boolean[] data = new boolean[n];
        for (int i = 0;i<n-1; i++){
            data[i] = false;
        }

        int counter = 0;//用于计数
        int index = 0;//用于报数
        while (true){
            if (!data[flag]){
                index++;
                if (counter == n-1){
                    System.out.println("last person==="+(flag+1));
                    break;
                }
                if (index == k){
                    data[flag] = true;
                    System.out.println("person ==="+(flag+1));
                    counter++;
                    index = 0;
                }
            }
            flag = (flag+1) % n;
        }
    }

    public static void main(String[] args) {
        JosephCircle josephCircle  =new JosephCircle();
        josephCircle.josephCircle(20,3);
    }
}
