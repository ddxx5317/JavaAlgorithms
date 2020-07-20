package com.ddxx.study.algorithms.callback;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/7/20
 */
public class Test {
    public static void main(String[] args) {
        Student student = new King();

        Teacher teacher = new Teacher(student);

        teacher.askQuestion();
    }
}
