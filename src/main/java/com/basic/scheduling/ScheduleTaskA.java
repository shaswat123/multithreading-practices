package com.basic.scheduling;

import com.basic.retvalues.ResultListener;

import java.time.LocalDate;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduleTaskA  extends TimerTask {

    private Long sleepTime;
    private String taskId;


    public ScheduleTaskA( Long sleepTime, String taskId) {

        this.sleepTime = sleepTime;
        this.taskId = taskId;

    }

    public void run() {

        LocalDate startTime=LocalDate.now();
        Date scheduleForRunningTime= new Date(super.scheduledExecutionTime());

        System.out.println("Thread " + Thread.currentThread().getName() + " Task ID " + taskId + "scheduled to run at : "
                +scheduleForRunningTime +"actually started at "+startTime);



        System.out.println("Thread " + Thread.currentThread().getName() + " sleeping for " + sleepTime);

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {

        }

        System.out.println("Thread " + Thread.currentThread().getName() + " Task ID " + taskId + " done");



    }

}
