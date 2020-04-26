package com.joke.study.thread;

/**
 * @author Drogon
 * @version 1.0
 * @ClassName HashInterruptException
 * @Description:
 * @date 2020/4/25 19:57
 */
public class HashInterruptException {

    private static class UseThread extends Thread{

        public UseThread(String name){
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(threadName + " interrupt flag is " + isInterrupted());
                    interrupt();
                    e.printStackTrace();
                }
                System.out.println(threadName);
            }
            System.out.println(threadName + " (while)interrupt flag is " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new UseThread("HashInterrupt");
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }

}
