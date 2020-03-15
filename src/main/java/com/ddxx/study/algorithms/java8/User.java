package com.ddxx.study.algorithms.java8;

/**
 * @Author: ddxx
 * @Date: 2020/3/14
 * @Description:
 */
public class User {
    private String name;
    private int age;
    private String school;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                '}';
    }
}
