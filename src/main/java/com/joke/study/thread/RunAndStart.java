package com.joke.study.thread;

/**
 * @author Drogon
 * @version 1.0
 * @ClassName RunAndStart
 * @Description:
 * @date 2020/4/2520:23
 */
public class RunAndStart {

    private static class ThreadRun extends Thread{

        @Override
        public void run() {
            int i = 90;
            String threadName = Thread.currentThread().getName();
            while(i > 0){
                try {
                    Thread.sleep(1000);
                    System.out.println("threadName " + threadName + " i = " + i--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadRun thread = new ThreadRun();
        thread.setName("thread");
        thread.setPriority(8);
//        thread.run();
        thread.start();
    }

}
