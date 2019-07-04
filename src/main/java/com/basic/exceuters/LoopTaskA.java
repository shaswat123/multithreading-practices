package com.basic.exceuters;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable {


    private volatile Integer id;

    public LoopTaskA(Integer id) {
        this.id= id;
    }

    public void run() {

        System.out.println("Task Id " + id + " Starting");

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
