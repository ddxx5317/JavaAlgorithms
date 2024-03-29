package com.ddxx.study.algorithms.java8;

import java.io.Serializable;

/**
 * @Author: ddxx
 * @Date: 2020/3/14
 * @Description:
 */
public class User implements Serializable {
    private static final long serialVersionUID = 2393514629537373761L;
    private String name;
    private int age;
    private String school;
    private Integer lines;

    public  User(){}
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }
    public User(String name, int age, String school,Integer lines) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.lines = lines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public boolean isOldUser(){
        if (this.getAge() >= 18){
            return true;
        }
        return  false;
    }

    public Integer getLines() {
        return lines;
    }

    public void setLines(Integer lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", lines=" + lines +
                '}';
    }
}
