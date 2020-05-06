package com.joke.study.thread.threadTools.forkJoin.sum;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumArray {
    private static class SumTask extends RecursiveTask<Integer>{

        private final static int THRESHOLD = ArrayTool.ARRAY_LENGTH/10;
        private int[] src;  //表示我们要实际统计得数组
        private int fromIndex;  //开始统统计的下标
        private int toIndex;    //统计到哪里结束的下标

        public SumTask(int[] src, int fromIndex, int toIndex) {
            this.src = src;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        protected Integer compute() {
            if(toIndex - fromIndex < THRESHOLD){
                int count = 0;
                for(int i = fromIndex; i<=toIndex; i++){
//                    try {
//                        Thread.sleep(1);
                        count = count + 1;
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
                return count;
            }else{
                int mid = (fromIndex+toIndex)/2;
                SumTask left = new SumTask(src, fromIndex, mid);
                SumTask right = new SumTask(src, mid+1, toIndex);
                invokeAll(left,right);
                return left.join() + right.join();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Task is Running......");

        long start = System.currentTimeMillis();


        ForkJoinPool pool = new ForkJoinPool();
        int[] src = ArrayTool.getArray();

        SumTask innerFind = new SumTask(src,0,src.length-1);


        pool.invoke(innerFind);
        System.out.println("Task is Running......");

        System.out.println("The count is "+ innerFind.join() + " spend time:"+(System.currentTimeMillis() - start)+"ms");


    }

}
