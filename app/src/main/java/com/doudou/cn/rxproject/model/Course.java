package com.doudou.cn.rxproject.model;

/**
 * Created by jinliang on 16-4-8.
 */
public class Course  {


    /**
     * subname : wen
     */

    public Course (String subname){
        this.subname = subname;
    }
    private String subname;

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }
}
