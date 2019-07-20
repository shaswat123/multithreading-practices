package com.basic.scheduling;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class SchedulingTaskForOneTimeExecution {

    public static void main(String[] args) throws InterruptedException{

        System.out.println("Thread " +Thread.currentThread().getName() +" starts");


        Timer timer = new Timer("Timer-thread",Boolean.FALSE);



        timer.schedule(new ScheduleTaskA(3000L,"1"),TimeUtils.getFutureTime(new Date(),5000));

        System.out.println("Task 1 schedule to run at specified delay of 5s ");

        ScheduleTaskA scheduleTaskB = new ScheduleTaskA(3000L,"2");
        timer.schedule(scheduleTaskB,2000L);

        System.out.println("Task 2 schedule to run at specified delay of 2s on  " +scheduleTaskB.scheduledExecutionTime());


        ScheduleTaskA scheduleTaskC = new ScheduleTaskA(3000L,"3");
        timer.schedule(scheduleTaskC,2500L);

        System.out.println("Task 3 schedule to run at specified delay of 2.5s on  " +scheduleTaskC.scheduledExecutionTime());


        timer.schedule(new ScheduleTaskA(3000L,"4"),TimeUtils.getFutureTime(new Date(),4000));


        System.out.println("Task 4 schedule to run at specified delay of 4s on  " +scheduleTaskC.scheduledExecutionTime());

        TimeUnit.MILLISECONDS.sleep(10000L);

        timer.cancel();

        System.out.println("Thread " +Thread.currentThread().getName() +" ends");

    }
}
