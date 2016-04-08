package com.doudou.cn.rxproject.rxjava;

import com.doudou.cn.rxproject.model.Course;
import com.doudou.cn.rxproject.model.Student;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by jinliang on 16-4-8.
 * <p/>
 * rxjava 中from 和 map 之间的转换
 */
public class Demo04 {
    private final static String TAG = Demo04.class.getName();

    @Test
    public void testDemo04() {

//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            list.add("location--:"+ i);
//        }
//        Observable.from(list).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                  System.out.println("Call:" + s);
//            }
//        });

        List<Student> list = new ArrayList<>();
        Student student;

        List<Course> listSubject = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listSubject.add(new Course("张三课程  0" + i));
        }


        student = new Student(listSubject, "张三", 10);
        list.add(student);

        List<Course> listSubject2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listSubject2.add(new Course("李四课程  0" + i));
        }
        student = new Student(listSubject2, "李四", 10);
        list.add(student);

        List<Course> listSubject3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listSubject3.add(new Course("王武课程  0" + i));
        }
        student = new Student(listSubject3, "王武", 10);
        list.add(student);


//        Observable.from(list).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.i(TAG, "call: ");
//                System.out.println(" Action1 call:" + s);
//            }
//        });


//        Observable.from(list).map(new Func1<Student, String>() {
//
//
//            @Override
//            public String call(Student student) {
//                System.out.println(" Func1 call:" + student.getName() + "---age--" + student.getAge());
//                return student.getName();
//            }
//        }).subscribe(new Action1<String>() {
//
//            @Override
//            public void call(String s) {
//                System.out.println("call:" + s);
//            }
//        });


        // 測試 Rxjava 中的filterMap ；


        Observable.from(list).flatMap(new Func1<Student, Observable<Course>>() {
            @Override
            public Observable<Course> call(Student student) {
                  System.out.println(" Fun1 Student call:" + student.getName());
                return Observable.from(student.getListSubject());
            }
        }).subscribe(new Action1<Course>() {
            @Override
            public void call(Course course) {

                   System.out.println("Action1  course call: " + course.getSubname());
            }
        });



    }

}

