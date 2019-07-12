package com.basic.terminate;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class LoopTaskH implements Callable<Long> {

    private volatile Integer id;
    private Long sleepTime;
    private Long number;
    private Long factorial;

    public LoopTaskH(Integer id, Long sleepTime, Long number) {
        this.id = id;
        this.sleepTime = sleepTime;
        this.number = number;
    }


    public Long call() {

        factorial = 1L;

        System.out.println("Task Id " + id + " Starting " + "With thread name " + Thread.currentThread().getName() + " is Daemon thread " + Thread.currentThread().isDaemon());

        for (Long i = 1L; i <= number; i++) {

            factorial *= i;

            try {
                TimeUnit.MILLISECONDS.sleep((sleepTime));
            }catch (InterruptedException e){

                System.out.println("Thread " + Thread.currentThread().getName() + " Interrupted and ends");
                factorial=-1L;
                break;

            }
        }

        System.out.println("Thread " + Thread.currentThread().getName() + " Ends");

        return factorial;

    }
}
