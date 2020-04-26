package com.joke.study.thread.waitnotify;

/**
 * @author Drogon
 * @version 1.0 测试notify/notifyAll
 * @ClassName WaitAndNotify
 * @Description:
 * @date 2020/4/2615:54
 */
public class WaitAndNotifyTest {

    private static Express express = new Express(0, Express.CITY);

    /*检查里程数变化的线程,不满足条件,线程一直等待*/
    private static class CheckKm extends Thread{
        @Override
        public void run() {
            express.waitKm();
        }
    }

    /*检查里程数变化的线程,不满足条件,线程一直等待*/
    private static class CheckSite extends Thread{
        @Override
        public void run() {
            express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        for(int i = 0; i<3 ;i++){
            new CheckSite().start();
//        }
//        for(int i = 0; i<3 ;i++){
            new CheckKm().start();
//        }

        Thread.sleep(3000);
//        express.changeKm();//地点开始变化
        express.changeSite();
    }

}
