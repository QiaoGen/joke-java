package com.joke.study.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Drogon
 * @version 1.0
 * @ClassName ThreadTest
 * @Description:
 * @date 2020/4/2322:43
 */
public class ThreadTest {

    public static void main1(String[] args) {

        //虚拟机线程管理接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("ThreadId:"+threadInfo.getThreadId() + "  ThreadName:"+threadInfo.getThreadName());
        }

        //result:
        /*ThreadId:6  ThreadName:Monitor Ctrl-Break
        ThreadId:5  ThreadName:Attach Listener      负责当前程序运行时相关的各种信息:内存的映像 线程栈 类信息统计 ....
        ThreadId:4  ThreadName:Signal Dispatcher    负责分发处理虚拟机信号的线程
        ThreadId:3  ThreadName:Finalizer            调用对象的finallizer方法的线程 !!待验证
        ThreadId:2  ThreadName:Reference Handler    负责清除引用的线程
        ThreadId:1  ThreadName:main                 主程序
        */
    }

    /*继承Thread*/
    class User extends Thread{

    }

    /*实现Runnable接口*/
    static class UserRun implements Runnable{

        @Override
        public void run() {
            System.out.println("implements Runnable");
        }
    }

    /**/
    static class UserCall implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("implements Callable");
            return "CallResult";
        }
    }

    /*启动线程*/
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UserRun userRun = new UserRun();
        UserCall userCall = new UserCall();
        new Thread(userRun).start();
        Thread thread = new Thread(userRun);
        thread.interrupt();

        FutureTask<String> futureTask = new FutureTask<>(userCall);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    /*结束线程:
    *   stop() interrupt() isInterrupted() static方法interrupted()
    */

}
