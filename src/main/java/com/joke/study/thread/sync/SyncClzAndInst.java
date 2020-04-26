package com.joke.study.thread.sync;

/**
 * @author Drogon
 * @version 1.0  演示对象锁和类锁
 * @ClassName SycClzAndInst
 * @Description:
 * @date 2020/4/2520:49
 */
public class SyncClzAndInst {

    /*使用类锁的线程*/
    private static class SyncClass extends Thread{
        @Override
        public void run() {
            System.out.println("Class is running...");
            try {
                SyncClzAndInst.syncClass();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*使用对象锁的线程*/
    private static class SyncInstance implements Runnable{

        private SyncClzAndInst syncClzAndInst;

        public SyncInstance(SyncClzAndInst syncClzAndInst){
            this.syncClzAndInst = syncClzAndInst;
        }

        @Override
        public void run() {
            System.out.println("Instance is running..." + syncClzAndInst);
            try {
                syncClzAndInst.instance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*使用对象锁的线程*/
    private static class SyncInstance2 implements Runnable {

        private SyncClzAndInst syncClzAndInst;

        public SyncInstance2(SyncClzAndInst syncClzAndInst){
            this.syncClzAndInst = syncClzAndInst;
        }

        @Override
        public void run() {
            System.out.println("Instance2 is running..." + syncClzAndInst);
            try {
                syncClzAndInst.instance2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void instance() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("syncInstance is goning..." + this.toString());
        Thread.sleep(2000);
        System.out.println("syncInstance is end..." + this.toString());
    }

    private synchronized void instance2() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("syncInstance2 is goning..." + this.toString());
        Thread.sleep(2000);
        System.out.println("syncInstance2 is end..." + this.toString());
    }

    private static synchronized void syncClass() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("syncClass is goning...");
        Thread.sleep(2000);
        System.out.println("syncClass is end...");
    }

    public static void main(String[] args) {
        SyncClzAndInst syncClzAndInst = new SyncClzAndInst();
        SyncClzAndInst syncClzAndInst2 = new SyncClzAndInst();

        Thread thread = new Thread(new SyncInstance(syncClzAndInst));
        Thread thread2 = new Thread(new SyncInstance2(syncClzAndInst));
        thread.start();
        thread2.start();

        SyncClass syncClass = new SyncClass();
        SyncClass syncClass2 = new SyncClass();
        syncClass.start();
        syncClass2.start();

    }
}
