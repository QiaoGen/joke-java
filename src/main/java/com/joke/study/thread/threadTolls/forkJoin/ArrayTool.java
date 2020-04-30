package com.joke.study.thread.threadTolls.forkJoin;


import java.util.Random;

public class ArrayTool {

    public static final int ARRAY_LENGTH= 4000;

    public static int[] getArray(){
        int[] result = new int[ARRAY_LENGTH];
        Random random = new Random();
        for(int i = 0 ; i < ARRAY_LENGTH; i++ ){
            result[i] = random.nextInt(ARRAY_LENGTH*3);
        }
        return result;
    }

}
