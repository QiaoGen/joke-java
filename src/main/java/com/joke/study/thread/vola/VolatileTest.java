package com.joke.study.thread.vola;

/**
 * @author Drogon
 * @version 1.0
 * @ClassName VolatileTest
 * @Description:
 * @date 2020/4/2521:58
 */
public class VolatileTest {

    private static class VolaClass implements Runnable{

        private volatile int a  = 0;

        @Override
        public void run() {
            try {
                String name = Thread.currentThread().getName();
                a = a + 1;
                System.out.println(name+"--------"+a);
                Thread.sleep(100);
                a = a + 1;
                System.out.println(name+"--------"+a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        VolaClass vola = new VolaClass();
        Thread thread = new Thread(vola);
        Thread thread2 = new Thread(vola);
        Thread thread3 = new Thread(vola);
        Thread thread4 = new Thread(vola);

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
