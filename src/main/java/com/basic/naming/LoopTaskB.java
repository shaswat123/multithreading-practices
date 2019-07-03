package com.basic.exceuters;

import java.util.concurrent.TimeUnit;

public class LoopTaskB implements Runnable {


    private volatile Integer id;

    public LoopTaskB(Integer id) {
        this.id = id;
    }

    public void run() {

        System.out.println("Task Id " + id + " Starting" +"With thread name "+Thread.currentThread().getName()) ;

        for (int i = 10; i > 0; i--) {
            System.out.println("Task Id " + id + " Tick " + i);

            try {
                TimeUnit.MILLISECONDS.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {

            }
        }

        System.out.println("Task Id " + id + " Done");

    }

}