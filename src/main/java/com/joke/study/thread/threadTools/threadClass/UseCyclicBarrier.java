package com.joke.study.thread.threadTools.threadClass;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Drogon
 * @Description:
 * @date 2020/5/9 11:57
 */
public class UseCyclicBarrier {

    private static CyclicBarrier barrier = new CyclicBarrier(5,new CollectThread());

    //存放子线程工作的容器
    private static ConcurrentHashMap<String, Long> resultMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i<= 4; i++) {
            Thread thread = new Thread(new SubThread());
            thread.start();
        }
    }

    //负责屏障开放以后的工作
    private static class CollectThread implements Runnable{
        @Override
        public void run() {
            StringBuilder result = new StringBuilder();
            for(Map.Entry<String,Long> workResult:resultMap.entrySet()){
                result.append("[" + workResult.getValue() + "]");
            }
            System.out.println("the result = " + result);
            System.out.println("do other business.......");
        }
    }

    //工作线程
    private static class SubThread implements Runnable{
        @Override
        public void run() {
            Long id = Thread.currentThread().getId();//线程本身的处理结果
            resultMap.put(Thread.currentThread().getId()+"",id);
            Random random = new Random();//随机决定工作线程的是否睡眠
            try {
                if(random.nextBoolean()){
                    Thread.sleep(2000+id);
                    System.out.println("Thread_" + id +".....do sth");
                }
                System.out.println("Thread_" + id + " is await");
                barrier.await();
                Thread.sleep(1000+id);
                System.out.println("Thread_" + id + ".....do its business");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
