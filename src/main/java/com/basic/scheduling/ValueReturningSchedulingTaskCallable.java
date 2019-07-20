package com.basic.scheduling;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ValueReturningSchedulingTaskCallable implements Callable<Integer> {

    private Integer x;
    private Integer y;
    private Long sleepTime;
    private Integer sum;

    private String taskId;

    public ValueReturningSchedulingTaskCallable(Integer x, Integer y, Long sleepTime, String taskId) {
        this.x = x;
        this.y = y;
        this.sleepTime = sleepTime;
        this.taskId = taskId;
    }

    public Integer call() throws Exception {

        System.out.println("Thread " + Thread.currentThread().getName() + " Task ID " + taskId + " started at "+ LocalDateTime.now());

        System.out.println("Thread " + Thread.currentThread().getName() + " sleeping for " + sleepTime);
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        sum = x + y;
        System.out.println("Thread " + Thread.currentThread().getName() + " Task ID " + taskId + " done at "+LocalDateTime.now());
        return sum;
    }
}
