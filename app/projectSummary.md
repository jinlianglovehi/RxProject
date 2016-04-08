###### 项目技术总结


##### Rxjava  Github 地址：
-  https://github.com/ReactiveX/RxJava
-  https://github.com/ReactiveX/RxAndroid
-  干货地址：http://gank.io/post/560e15be2dca930e00da1083
-  翻译地址：https://mcxiaoke.gitbooks.io/rxdocs/content/Scheduler.html

##### Rxjava 技术

- 主要两个核心：Observables（被观察者，事件源）和Subscribers（观察者,订阅者）
- just () 讲数据一个一个的输出 : 发出事件  new Fun1 函数中 第一个参数： 传入参数， 第二个参数位 返回参数。
- from ： 接受的是一个集合, 可以讲集合中的数据逐一执行操作单元
- map ：是指 just 发出事件与订阅处理事件之间的数据转换
- subscribe： 订阅处理 （Action1) onnext, (Action1) onerror ,(Action0)oncomplete ）


##### 1.Observable和Subscriber可以做任何事情

- Observable可以是一个数据库查询，Subscriber用来显示查询结果；
- Observable可以是屏幕上的点击事件，Subscriber用来响应点击事件；
- Observable可以是一个网络请求，Subscriber用来显示请求结果。
- Observable 相当于一个过程中的入口， Subscriber 相当于一个过程中的出口

##### 2.Observable和Subscriber是独立于中间的变换过程的。
- 在Observable和Subscriber中间可以增减任何数量的map。

##### 3 Rxjava中的函数、
- from subscribe： 可以处理集合 循环的执行 订阅的执行单元

```
  List list = new ArrayList();
        for (int i = 0; i <3 ; i++) {
            list.add("url"+i);
        }
        Observable.from(list).subscribe(new Action1<String>(){
sd
            @Override
            public void call(String s) {
                  System.out.println("call:" +s );
            }
        });

  Log日志：
  call:url0
  call:url1
  call:url2

```

- flatMap 函數  返回的是Obserable

```
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

Log 日誌輸出
     Fun1 Student call:张三
    Action1  course call: 张三课程  00
    Action1  course call: 张三课程  01
    Action1  course call: 张三课程  02
     Fun1 Student call:李四
    Action1  course call: 李四课程  00
    Action1  course call: 李四课程  01
    Action1  course call: 李四课程  02
     Fun1 Student call:王武
    Action1  course call: 王武课程  00
    Action1  course call: 王武课程  01
    Action1  course call: 王武课程  02


```

- flatMap 和 map 之间的区别

>   和 map() 不同的是， flatMap() 中返回的是个 Observable 对象


- lift 变换


##### 4 线程控制 调度器

-  Schedulers.immediate()： 直接在当前的线程中执行。
-  Schedulers.newThread()： 总是创建新的线程执行。
-  Schedulers.io():  io 文件的处理。
-  AndroidSchedulers.mainThread()：在主线程中执行。




