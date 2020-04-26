package com.joke.study.thread.waitnotify;

/**
 * @author Drogon
 * @version 1.0 快递实体类
 * @ClassName Express
 * @Description:
 * @date 2020/4/2615:39
 */
public class Express {

    public final static String CITY = "NanJing";

    private int km;

    /*快递到达地点*/
    private String site;

    public Express(){

    }

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    /*变化公里数,然后通知处于wait状态并需要处理公里数的线程进行业务处理*/
    public synchronized void changeKm(){
        this.km = 101;
        notifyAll();
    }

    /*变化地点,然后通知处于wait状态并需要处理地点的线程进行业务处理*/
    public synchronized void changeSite(){
        this.site = "ChuZhou";
        notifyAll();
    }

    public synchronized void waitKm(){
        while(this.km <= 100){
            try {
                wait();
                System.out.println("check km thread ["+Thread.currentThread().getId()+"] is be notifed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the km is "+this.km + ",I will change db." );
    }

    public synchronized void waitSite(){
        while(CITY.equals(this.site) ){
            try {
                wait();
                System.out.println("check site thread ["+Thread.currentThread().getId()+"] is be notifed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the site is "+this.site + ",I will change db." );

    }
}
