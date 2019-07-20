package com.basic.scheduling;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class SchedulingTaskForFixedDelayRepeatedExecutions {


    public static void main(String[] args) throws InterruptedException{

        System.out.println("Thread "+Thread.currentThread().getName() +" starts here");

        System.out.println("Current time is "+ LocalDateTime.now());

        Timer timer= new Timer("Timer-thread",Boolean.TRUE);

        Date scheduleTime= TimeUtils.getFutureTime(new Date(),3000L);
        Long intervalMills=2000L;

        timer.schedule(new ScheduleTaskA(1000L,"1"),scheduleTime,intervalMills);

        System.out.println("Task 1 first run scheduled for "+ scheduleTime+" and then repeated at an interval of 2s");


        Long delayInMills= TimeUnit.MILLISECONDS.toMillis(4000);

        Long intervalInMills=TimeUnit.MILLISECONDS.toMillis(2000);

        timer.schedule(new ScheduleTaskA(1000L,"2"),delayInMills,intervalInMills);

        System.out.println("Task 2 first run scheduled after  "+ scheduleTime+" and then repeated at an interval of 2s");

        TimeUnit.MILLISECONDS.sleep(16000L);

        System.out.println("Cancelling the timer now");

        timer.cancel();

        System.out.println(Thread.currentThread().getName()+ " Thread ends");


    }

}
