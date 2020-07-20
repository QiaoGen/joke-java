package com.joke.study.thread.threadTools.semaphore;

import java.sql.Connection;
import java.util.Random;

/**
 * 数据库连接池测试
 */
public class AppTest {

    private static DBConnectionPool dbPool = new DBConnectionPool();

    /**
     * 业务线程
     */
    private static class BusiThread extends Thread{

        @Override
        public void run() {
            Random r = new Random();//每个线程模拟持续的时间不同
            long start = System.currentTimeMillis();
            try {
                Connection connect = dbPool.takeConnection();
                System.out.println("Thread_"+Thread.currentThread().getId()+"  获取数据库连接共耗时【"+(System.currentTimeMillis()-start)+"】ms");
                Thread.sleep(100+ r.nextInt(100));//模拟业务操作，线程持有连接查询数据
                System.out.println("数据查询完成，归还连接！");
                dbPool.returnConnection(connect);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50 ; i++){
            Thread thread = new BusiThread();
            thread.start();
        }
    }
}
