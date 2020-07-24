package com.joke.study.thread.threadTools.cas;

import java.util.concurrent.atomic.AtomicReference;

/** 演示引用类型的原子操作类 */
public class AtomicReferenceTest {

  static AtomicReference<UserInfo> userRel = new AtomicReference<>();

  public static void main(String[] args) {
    // bei修改的实例
    UserInfo user = new UserInfo("张三", 12);
    userRel.set(user);
    UserInfo updateUser = new UserInfo("里斯", 14);
    userRel.compareAndSet(user, updateUser);
    System.out.println(userRel.get().getName()+"_"+userRel.get().getAge());
    System.out.println(user.getName()+"_"+user.getAge());
  }
}

class UserInfo {
  private String name;
  private int age;
  public UserInfo(String name, int age) {
    this.name = name;
    this.age = age;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
}
