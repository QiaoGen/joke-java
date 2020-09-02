package com.joke.study.templete;

/**
 * 静态内部类单例
 */
public class SingletonInnerClass {

    private SingletonInnerClass(){}

    private static class InnerInstance{
        static {
            System.out.println("构建InnerInstance");
        }
       private static SingletonInnerClass instance = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance(){
        return InnerInstance.instance;
    }

  public static void main(String[] args) {
      for (int i = 0; i < 100; i++) {
          new Thread(
                  () -> {
                      SingletonInnerClass instance = null;
                        instance = SingletonInnerClass.getInstance();
                      System.out.println(instance.hashCode());
                  })
                  .start();
      }
  }
}
