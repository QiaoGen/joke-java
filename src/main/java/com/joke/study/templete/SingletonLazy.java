package com.joke.study.templete;

/** 懒汉模式 */
public class SingletonLazy {

  private static volatile SingletonLazy instance = null;

  private SingletonLazy() {}

  public static SingletonLazy getInstance() throws InterruptedException {
    // 业务操作
    if (instance == null) {
      synchronized (SingletonLazy.class) {
        // 线程共享资源加锁
          if(instance == null){
              Thread.sleep(10);
              instance = new SingletonLazy() {};
          }
      }
    }
    return instance;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      new Thread(
              () -> {
                SingletonLazy instance = null;
                try {
                  instance = SingletonLazy.getInstance();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                System.out.println(instance.hashCode());
              })
          .start();
    }
  }
}
