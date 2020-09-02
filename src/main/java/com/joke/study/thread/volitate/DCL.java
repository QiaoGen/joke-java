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

         happens_before原则(JVM规定必须遵守的原则)
         程序次序规则：同一个线程内，按照代码出现的顺序，前面的代码先行与后面的代码，准确的说是控制流顺序，因为要考虑分支和循环结构。
         管程锁定规则：一个unlock操作先行发生于后面（时间上）对同一个锁的lock操作
         volatitle变量规则：对一个volatile变量的写操作先行发生于后面（时间上）对这个变量的读操作。
         线程启动规则：Thread的start方法先行发生于这个线程的每一个操作。
         线程终止规则：线程所有操纵都先行于此线程的终止检测。可以通过Thread.join()方法结束、Thread.isAlive()的返回值等手段检测线程的终止。
         线程的中断规则：对线程interrupt()的方法调用先行发生于被中断线程的代码检测到中断事件的发生，可以通过Thread.interrupt()方法检测线程是否中断。
         对象终结规则：一个对象的初始化完成先行发生于发生它的finalize()方法的开始。
         传递性：如果操作A先行于操作B，操作B先行于操作C，那么操作A先行于操作C


         */
    }
}
