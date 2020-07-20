package com.ddxx.study.algorithms.callback;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/7/20
 */
public class Teacher implements Callback{
    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        System.out.println("同学、请问1+1=？");
        student.resolveQuestion(this);
    }


    @Override
    public void tellAnswer(int answer) {
        System.out.println("知道了，你的答案是" + answer);
    }
}
