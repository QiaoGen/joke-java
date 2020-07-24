package com.joke.study.thread.threadTools.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/** 带版本戳的原子类 */
public class AtomicStampedReferenceTest {

  static AtomicStampedReference<String> atoStaRef = new AtomicStampedReference<>("张三", 0);

  public static void main(String[] args) throws InterruptedException {
    final int oldStamp = atoStaRef.getStamp();
    final String oldReference = atoStaRef.getReference();

    System.out.println(oldReference + "---------" + oldStamp);

    Thread rightThread =
        new Thread(
            () ->
                System.out.println(
                    Thread.currentThread().getName()
                        + "当前变量值"
                        + oldReference
                        + "-----"
                        + oldStamp
                        + atoStaRef.compareAndSet(
                            oldReference, oldReference + "java", oldStamp, oldStamp + 1)));
    Thread errorThread =
        new Thread(
            () ->
                System.out.println(
                    Thread.currentThread().getName()
                        + "当前变量值"
                        + oldReference
                        + "-----"
                        + oldStamp
                        + atoStaRef.compareAndSet(
                            oldReference, oldReference + "java", oldStamp, oldStamp + 1)));

    rightThread.start();
    rightThread.join();
    errorThread.start();

    System.out.println(atoStaRef.getReference() + ":" + atoStaRef.getStamp());
  }
}
