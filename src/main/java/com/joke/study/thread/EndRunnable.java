package com.joke.study.thread;

/**
 * @author Drogon
 * @version 1.0
 * @ClassName EndRunnable
 * @Description:
 * @date 2020/4/2519:48
 */
public class EndRunnable {

    private static class UseThread implements Runnable{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("threadName:" + threadName + "is run");
            }
            System.out.println(threadName + " interrupt flag is " + Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread useThread = new UseThread();
        Thread thread = new Thread(useThread,"EndRunnable");
        thread.start();
        Thread.sleep(20);
        thread.interrupt();
    }
}
