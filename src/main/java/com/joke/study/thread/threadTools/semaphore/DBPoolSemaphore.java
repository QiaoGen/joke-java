package com.joke.study.thread.threadTools.semaphore;

import com.joke.study.thread.pool.SqlConnectionImpl;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @author Drogon
 * @Description: 演示Semaphore用法, 一个数据库连接池的实现
 * @date 2020/5/9 12:47
 */
public class DBPoolSemaphore {

    private static final int POOL_SIZE = 10;

    //useFul表示可用的数据库链接,useLess表示已用的数据库链接
    private final Semaphore useFul,useLess;

    public DBPoolSemaphore(){
        this.useFul = new Semaphore(POOL_SIZE);
        this.useLess = new Semaphore(0);
    }

    //存放数据库连接的容器
    private static LinkedList<Connection> pool = new LinkedList<>();

    //初始化池
    static {
        for(int i = 0; i < POOL_SIZE; i++){
            pool.add(SqlConnectionImpl.fetchConnection());
        }
    }

    /**
     * 归还链接
     */
    public void returnConnect(Connection conn) throws InterruptedException {
        if(conn != null){
            System.out.println("当前有"+useFul.getQueueLength()+"线程等待链接;可用连接数"+useFul.availablePermits() );
//            useLess.acquire();
            synchronized (pool){
                pool.addLast(conn);
            }
            useFul.release();
        }
    }

    /**
     * 从池中获取链接
     */
    public Connection takeConnect() throws InterruptedException {
        useFul.acquire();
        Connection conn;
        synchronized (pool){
            conn = pool.removeFirst();
        }
//        useLess.release();
        return conn;
    }
}
