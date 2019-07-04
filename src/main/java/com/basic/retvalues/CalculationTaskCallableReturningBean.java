package com.basic.retvalues;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskCallableReturningBean implements Callable<TaskResult<String,Integer>> {

    private Integer x;
    private Integer y;
    private Long sleepTime;
    private Integer sum;

    private String taskId;

    public CalculationTaskCallableReturningBean(Integer x, Integer y, Long sleepTime, String taskId) {
        this.x = x;
        this.y = y;
        this.sleepTime = sleepTime;
        this.taskId = taskId;
    }

    public TaskResult<String, Integer> call() throws Exception {
        System.out.println("Thread " + Thread.currentThread().getName() + " Task ID " + taskId + " started");

        System.out.println("Thread " + Thread.currentThread().getName() + " sleeping for " + sleepTime);
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        sum = x + y;
        System.out.println("Thread " + Thread.currentThread().getName() + " Task ID " + taskId + " done");
        return new TaskResult<String, Integer>(taskId,sum);
    }
}
