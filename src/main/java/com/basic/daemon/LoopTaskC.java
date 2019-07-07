package com.basic.daemon;

import java.util.concurrent.TimeUnit;

public class LoopTaskC implements Runnable{

    private volatile Integer id;
    private Long sleepTime;

    public LoopTaskC(Integer id,Long sleepTime) {
        this.id = id;
        this.sleepTime=sleepTime;
    }

    public void run() {

        System.out.println("Task Id " + id + " Starting " +"With thread name "+Thread.currentThread().getName()+"is Daemon thread"+Thread.currentThread().isDaemon()) ;

        for (int i = 10; i > 0; i--) {
            System.out.println("Task Id " + id + " Tick " + i);

            try {
                TimeUnit.MILLISECONDS.sleep((sleepTime));
            } catch (InterruptedException e) {

            }
        }

        System.out.println("Task Id " + id + " Done");

    }


}
