package com.joke.study.thread.threadTools.threadClass;

import java.util.concurrent.CountDownLatch;

/**
 * @author Drogon
 * @Description: 演示CountDownLatch,有5个初始化的线程,6个扣除点,扣除完毕之后,主线程和业务线程才能继续工作
 * @date 2020/5/7 0:34
 */
public class UseCountDownLatch {

    static CountDownLatch latch = new CountDownLatch(6);

    //初始化线程
    private static class InitThread implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread_" + Thread.currentThread().getId() + " ready init work.....");
//            for (int i = 0; i<2; i++) {
            System.out.println("Thread_" + Thread.currentThread().getId() + " continue do its work.....");
//            }
            latch.countDown();//初始化线程完成工作了,countDown方法只扣减一次
        }
    }

    //业务线程
    private static class BusiThread implements Runnable{
        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i<3; i++) {
                System.out.println("BusiThread_" + Thread.currentThread().getId() + " do business.....");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //单独的初始化线程,初始化分为2步,需要扣减2次
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                    System.out.println("Thread_"+Thread.currentThread().getId() + " ready init work step 1st.....");
                    latch.countDown();//每完成一步,扣减一次
                    System.out.println("begin step 2nd........");
                    Thread.sleep(1);
                    System.out.println("Thread_"+Thread.currentThread().getId() + " ready init work step 2nd.....");
                    latch.countDown();//每完成一步,扣减一次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new BusiThread()).start();
        for (int i = 0; i<=3; i++) {
            Thread thread = new Thread(new InitThread());
            thread.start();
        }
        latch.await();
        System.out.println("Main do its work..........");
    }

}
