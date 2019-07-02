package com.basic.exceuters;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable {

    private static int count = 0;
    private static int id;

    public LoopTaskA() {
        this.id= ++count;
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
