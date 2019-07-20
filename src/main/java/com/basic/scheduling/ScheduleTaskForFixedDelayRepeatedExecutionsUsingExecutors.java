package com.basic.scheduling;

import com.basic.naming.NamedThreadFactory;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTaskForFixedDelayRepeatedExecutionsUsingExecutors {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Thread " + Thread.currentThread().getName() + " starts");


        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory());

        System.out.println("Current time " + LocalDateTime.now());

        scheduledExecutorService.scheduleAtFixedRate(new ScheduleTaskB(3000L,"1"),4,2, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(15000);

        scheduledExecutorService.shutdown();
        System.out.println("Thread " + Thread.currentThread().getName() + " ends");


    }
}
