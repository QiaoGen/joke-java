package com.joke.study.thread;

/**
 * @author Drogon
 * @version 1.0
 * @ClassName EndThread
 * @Description:
 * @date 2020/4/2519:40
 */
public class EndThread {

    private static class UseThread extends Thread{

        public UseThread(String name){
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){
                System.out.println("threadName:" + threadName + "is run");
            }
            System.out.println(threadName + "interrupt flag is " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new UseThread("endThread");
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }
}
