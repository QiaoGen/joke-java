package com.joke.study.thread;

/**
 * @author Drogon
 * @version 1.0
 * @ClassName ThreadLocalExample
 * @Description:
 * @date 2020/4/2522:16
 */
public class ThreadLocalExample {

    static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

    /*运行三个线程*/
    private void StartThreadArray(){
        Thread[] runs = new Thread[3];
        for(int i = 0 ; i < runs.length ; i++){
            runs[i] = new Thread(new ThreadTest(i));
        }
        for(int i = 0 ; i < runs.length ; i++){
            runs[i].start();
        }
    }

    /*测试线程,线程的工作是将ThreadLocal变量的值变化,并回写,观察线程之间是否影响*/
    private static class ThreadTest implements Runnable{
        int id;

        public ThreadTest(int id){
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":start");
            Integer s = threadLocal.get();
            s = s + id;
            threadLocal.set(s);
            System.out.println(Thread.currentThread().getName() + ":"+threadLocal.get());
        }
    }

    public static void main(String[] args) {
        ThreadLocalExample example = new ThreadLocalExample();
        example.StartThreadArray();
    }

}
