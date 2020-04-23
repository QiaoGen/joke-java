package com.joke.study.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaobaomin
 * @version 1.0
 * @ClassName ThreadTest
 * @Description:
 * @date 2020/4/2322:43
 */
public class ThreadTest {

    public static void main(String[] args) {

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

}
