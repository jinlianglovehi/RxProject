package com.doudou.cn.rxproject.model;

import java.util.List;

/**
 * Created by jinliang on 16-4-8.
 */
public class Student {

    public List<Course> getListSubject() {
        return listSubject;
    }

    public void setListSubject(List<Course> listSubject) {
        this.listSubject = listSubject;
    }

    public Student(List<Course> listSubject, String name, int age){
        this.listSubject = listSubject;
        this.name = name;
        this.age = age;
    }
    /**
     * name : huhu
     * age : 20
     */

    private List<Course> listSubject;




   private  String name;
    private int age;

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
}
