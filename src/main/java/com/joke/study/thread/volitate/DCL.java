package com.joke.study.thread.volitate;


/**
 * @author Drogon
 * @Description:
 * @date 2020/8/5 23:49
 */
public class DCL {

    private DCL(){}

    private static volatile DCL INSTANCE;

    public static DCL getInstence(){
        if(INSTANCE == null){
            synchronized(DCL.class){
                if(INSTANCE == null){
                    INSTANCE = new DCL();
                }
            }
        }
        return INSTANCE;
    }


    public static void main(String[] args) {
        for(int i = 0; i <= 100; i++){
            new Thread(()-> {
                DCL instence = DCL.getInstence();
                System.out.println(instence.hashCode());
            }).start();
        }

        /**
         对象的创建过程:
         汇编:
         0 new #2 <T>
         3 dup
         4 invokespecial #3 <T.<init>>
         7 astore_1
         8 return

         volitate如何保证不会指令重排?

         cpu/jvm
         cpu不管你,想重排就重排

         */
    }
}
