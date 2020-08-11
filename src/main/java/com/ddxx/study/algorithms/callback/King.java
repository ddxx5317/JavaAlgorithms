package com.ddxx.study.algorithms.callback;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/7/20
 */
public class King implements Student{

    @Override
    public void resolveQuestion(Callback callback) {
            // 模拟解决问题
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            // 回调，告诉老师作业写了多久
            callback.tellAnswer(2);
    }
}