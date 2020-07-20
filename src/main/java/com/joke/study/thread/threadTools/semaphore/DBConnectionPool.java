package com.joke.study.thread.threadTools.semaphore;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * 类说明：Semaphore实现数据库连接池
 */
public class DBConnectionPool {

    private final static int POOL_SIZE = 10;
    //useful表示可用数据库连接，useless表示已用的数据库连接
    private final Semaphore useful,useless;

    public DBConnectionPool(){
        this.useful = new Semaphore(POOL_SIZE);
        this.useless = new Semaphore(0);
    }

    //存放数据库连接的容器
    private static LinkedList<Connection> pool = new LinkedList<>();

    //初始化
    static {
        for(int i = 0; i< POOL_SIZE ;i++){
            pool.addLast(SqlConnectionImpl.fetchConnection());
        }
    }

    /**
     * 归还连接
     */
    public void returnConnection(Connection connection) throws InterruptedException{
        if(connection != null){
            System.out.println("当前有"+useful.getQueueLength()+"个线程等待数据库连接！！可用连接数："+useful
            .availablePermits());
            useless.acquire();
            synchronized (pool){
                pool.addLast(connection);
            }
            useful.release();
        }
    }

    /**
     * 从池中获取连接
     * @return
     * @throws InterruptedException
     */
    public Connection takeConnection() throws InterruptedException{
        useful.acquire();
        Connection conn;
        synchronized (pool) {
            conn = pool.removeFirst();
        }
        useless.release();
        return conn;
    }

}
