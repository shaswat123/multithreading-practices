package com.basic.scheduling;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ScheduleTaskB implements Runnable {


    private Long sleepTime;
    private String taskId;


    public ScheduleTaskB(Long sleepTime, String taskId) {

        this.sleepTime = sleepTime;
        this.taskId = taskId;

    }


    @Override
    public void run() {

        LocalDate startTime = LocalDate.now();


        System.out.println("Thread " + Thread.currentThread().getName() + " Task ID " + taskId + "actually started at " + startTime);
        System.out.println("Thread " + Thread.currentThread().getName() + " sleeping for " + sleepTime);

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {

        }

        System.out.println("Thread " + Thread.currentThread().getName() + " Task ID " + taskId + " done");


    }


}
