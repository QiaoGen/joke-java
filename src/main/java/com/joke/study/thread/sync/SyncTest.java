package com.joke.study.thread.sync;

/**
 * @author Drogon
 * @version 1.0 演示对象锁和类锁
 * @ClassName SyncTest
 * @Description:
 * @date 2020/4/2520:47
 */
public class SyncTest {

    private volatile int age = 100000;

    public int getAge(){
        return age;
    }

    public void setAge(){
        this.age = 10;
    }

    private static class TestThread extends Thread{

        private SyncTest syncTest;

        public TestThread(SyncTest syncTest,String name){
            super(name);
            this.syncTest = syncTest;
        }

        @Override
        public void run() {
            for(int i = 0 ; i < 100000 ; i++){
              syncTest.test();
            }
            System.out.println(Thread.currentThread().getName() );
        }
    }

    private void test(){
        age++;
    }

    public static void main(String[] args) {
        SyncTest test = new SyncTest();
        TestThread thread = new TestThread(test,"threadOne");
        TestThread thread2 = new TestThread(test,"threadTwo");
        thread.start();
        thread2.start();
    }
}
