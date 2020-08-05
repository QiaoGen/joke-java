package com.joke.study.thread.volitate;

/**
 * @author Drogon
 * @Description:
 * @date 2020/8/5 23:26
 */
public class VolitateTest {

    private static int x= 0,y=0;
    private static int a= 0,b=0;


    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for(;;){
            i++;
            x = 0;y = 0;
            a = 0;b = 0;

            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });

            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = b;
                }
            });

            one.start();
            two.start();

            one.join();
            two.join();

            String result = "第"+i+"次("+x+","+y+")";
            if(x == 0 && y == 0){
                System.out.println(result);
                break;
            }else{
                System.out.println(".");
            }
        }




    }

}
