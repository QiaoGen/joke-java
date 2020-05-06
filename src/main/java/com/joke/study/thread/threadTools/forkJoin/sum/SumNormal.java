package com.joke.study.thread.threadTools.forkJoin.sum;

public class SumNormal {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] array = ArrayTool.getArray();
        int sum = 0;
        for(int i = 0 ; i < array.length ; i++){
            sum += array[i];
        }
        System.out.println("The count is "+ array.length + " spend time:"+(System.currentTimeMillis() - start)+"ms");
    }

}
