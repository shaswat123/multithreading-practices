package com.basic.waiting;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTask implements Runnable {


    private volatile Integer id;
    private Long sleepTime;
    CountDownLatch latch ;

    public CountDownLatchTask(Integer id,Long sleepTime ,CountDownLatch latch){

        this.id = id;
        this.sleepTime=sleepTime;
        this.latch=latch;


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

        if(latch!=null){

            latch.countDown();

            System.out.println("Task Id " + id + "of"+Thread.currentThread().getName()+" latch count is "+latch.getCount());
        }


    }
}
