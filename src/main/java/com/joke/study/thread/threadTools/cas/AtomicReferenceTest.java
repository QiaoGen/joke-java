package com.joke.study.thread.threadTools.cas;

/**
 * 演示引用类型的原子操作类
 */
public class AtomicReferenceTest {
    public static void main(String[] args) {
        UserInfo a = new UserInfo();

    }


}

class UserInfo(){
    private String name;
    private int age;
    public UserInfo(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}