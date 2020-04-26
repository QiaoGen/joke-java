package com.joke.study.thread.pool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author Drogon
 * @Description: 实现一个数据库连接池
 * @date 2020/4/26 16:47
 */
public class DBPool {

    /*数据库池的容器*/
    private static LinkedList<Connection> pool = new LinkedList<>();

    public DBPool(int initSize){
        if(initSize > 0){
            for(int i = 0; i<initSize ; i++){
                pool.add(SqlConnectionImpl.fetchConnection());
            }
        }
    }

    /*在mills时间范围内还拿不到数据库连接,就返回null*/
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            if(mills < 0){
                while(pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                long overTime = System.currentTimeMillis() + mills;
                long remain = mills;
                while (pool.isEmpty() && remain>0){
                    pool.wait();
                    remain = overTime - System.currentTimeMillis();
                }
                Connection result = null;
                if(!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }

    /*放回数据库连接*/
    public void releaseConn(Connection conn){
        if(conn != null){
            synchronized (pool){
                pool.addLast(conn);
                pool.notifyAll();
            }
        }
    }
}
