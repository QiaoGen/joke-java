package com.joke.study.thread.threadTools.semaphore;

import java.sql.Connection;
import java.util.Random;

/**
 * @author Drogon
 * @Description:
 * @date 2020/5/9 12:52
 */
public class Test {

    private static DBPoolSemaphore pool = new DBPoolSemaphore();

    private static class BusiThread extends Thread{

        @Override
        public void run() {
            Random r = new Random();//让每个线程持有链接的时间不一样

            long start = System.currentTimeMillis();
            try {
                Connection connect = pool.takeConnect();
                System.out.println("Thread_" + Thread.currentThread().getId() + "_获取数据库连接共耗时["+ (System.currentTimeMillis()-start)+"]ms.");
                Thread.sleep(100+r.nextInt(100));//模拟业务操作,线程持有连接查询数据
                System.out.println( "数据查询完成,归还链接!!!");
                pool.returnConnect(connect);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0;i<50 ;i++){
            Thread thread = new Thread(new BusiThread());
            thread.start();
        }
    }

}
