package com.joke.study.thread;

/**
 * @author Drogon
 * @version 1.0
 * @ClassName Practice
 * @Description:
 * @date 2020/4/260:20
 */
public class Practice {

    //站台卖票
//    private static ThreadLocal<Integer> ThreadTick = ThreadLocal.withInitial(() -> 20);

    private static class Station implements Runnable{
//        private Practice practice;
//
//        private Station(Practice practice){
//            this.practice = practice;
//        }

        static int tick =10;

        static Object lock = "aa";

        @Override
        public void run() {
//            int tick = ThreadTick.get();
            try {
                sell();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void sell() throws InterruptedException {
            System.out.println(tick);
            while(tick > 0){
                synchronized (lock){
                    String threadName = Thread.currentThread().getName();
                    if(tick>0){
                        System.out.println(threadName+"卖出了第"+tick+"张票");
                        tick--;
//                    ThreadTick.set(tick);
//                        Thread.sleep(1000);
                    }else{
                        System.out.println("票卖完了");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Practice practice = new Practice();
        Station station = new Station();
        Thread thread1 = new Thread(station, "station1");
        Thread thread2 = new Thread(station, "station2");
        Thread thread3 = new Thread(station, "station3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
