package com.basic.terminate;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class LooptaskG implements Callable<Long> {

    private volatile Integer id;
    private Long sleepTime;
    private volatile Boolean shutDown = Boolean.FALSE;
    private Long number;
    private Long factorial;

    public LooptaskG(Integer id, Long sleepTime, Long number) {
        this.id = id;
        this.sleepTime = sleepTime;
        this.number = number;
    }


    public Long call() throws Exception {

        factorial = 1L;

        System.out.println("Task Id " + id + " Starting " + "With thread name " + Thread.currentThread().getName() + " is Daemon thread " + Thread.currentThread().isDaemon());

        for (Long i = 1L; i <= number; i++) {

            factorial *= i;

            TimeUnit.MILLISECONDS.sleep((sleepTime));

            synchronized (this) {
                if (shutDown) {
                    break;

                }
            }


        }

        System.out.println("Thread " + Thread.currentThread().getName() + " Ends");

        return factorial;


    }

    public void cancel() {

        synchronized (this) {
            this.shutDown = Boolean.TRUE;
        }
    }

}
