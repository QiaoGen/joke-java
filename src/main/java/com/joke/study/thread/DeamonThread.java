package com.joke.study.thread;

/**
 * @author Drogon
 * @version 1.0
 * @ClassName DeamonThread
 * @Description:
 * @date 2020/4/2520:35
 */
public class DeamonThread {
    private static class ThreadRun extends Thread{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){
                System.out.println("threadName:" + threadName + " is run");
            }
            System.out.println(threadName + "interrupt flag is " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadRun thread = new ThreadRun();
        thread.setName("DeamonThread");
        thread.setDaemon(true);
        thread.start();
        thread.sleep(5);
//        thread.interrupt();
    }
}
