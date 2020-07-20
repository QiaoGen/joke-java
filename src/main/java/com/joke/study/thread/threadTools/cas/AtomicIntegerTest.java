package com.joke.study.thread.threadTools.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    static AtomicInteger i = new AtomicInteger(10);

    public static void main(String[] args) {
        System.out.println(i.getAndIncrement());
        System.out.println(i.incrementAndGet());
        System.out.println(i.get());
    }
}
