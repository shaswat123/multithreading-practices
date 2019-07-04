package com.basic.retvalues;

import java.util.concurrent.TimeUnit;

public class ValueReturningTask implements Runnable {

    private Integer x;
    private Integer y;
    private Long sleepTime;
    private Integer sum;

    private String taskId;
    private ResultListener<Integer> resultListener;


    public ValueReturningTask(Integer x, Integer y, Long sleepTime, String taskId, ResultListener<Integer> resultListener) {
        this.x = x;
        this.y = y;
        this.sleepTime = sleepTime;
        this.sum = sum;
        this.taskId = taskId;
        this.resultListener=resultListener;
    }

    public void run() {

        System.out.println("Thread " + Thread.currentThread().getName() + " Task ID " + taskId + " started");

        System.out.println("Thread " + Thread.currentThread().getName() + " sleeping for " + sleepTime);

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {

        }

        sum = x + y;
        System.out.println("Thread " + Thread.currentThread().getName() + " Task ID " + taskId + " done");

        resultListener.notifyResult(sum);


    }
}
