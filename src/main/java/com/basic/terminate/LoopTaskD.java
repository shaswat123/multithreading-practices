package com.basic.terminate;

import java.util.concurrent.TimeUnit;

public class LoopTaskD implements Runnable{

    private volatile Integer id;
    private Long sleepTime;
    private volatile Boolean shutDown = Boolean.FALSE;

    public LoopTaskD(Integer id, Long sleepTime) {
        this.id = id;
        this.sleepTime = sleepTime;
    }


    public void run() {

        System.out.println("Task Id " + id + " Starting " + "With thread name " + Thread.currentThread().getName() + "is Daemon thread" + Thread.currentThread().isDaemon());

        for (int i = 10; ; i--) {
            System.out.println("Task Id " + id + " Tick " + i);

            try {
                TimeUnit.MILLISECONDS.sleep((sleepTime));
            } catch (InterruptedException e) {

            }

            synchronized (this) {
                if (shutDown) {
                    break;
                }
            }

        }


    }

    public void cancel() {

        System.out.println("Thread " + Thread.currentThread().getName() + " shutting down");

        synchronized (this) {

            this.shutDown = Boolean.TRUE;

        }

    }

}
