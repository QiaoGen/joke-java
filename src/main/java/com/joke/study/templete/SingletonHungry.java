package com.joke.study.templete;

/** 饿汉模式 */
public class SingletonHungry {

    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry(){}

    public static SingletonHungry getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonHungry instance1 = SingletonHungry.getInstance();
        SingletonHungry instance2 = SingletonHungry.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}
