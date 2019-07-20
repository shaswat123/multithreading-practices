package com.basic.scheduling;

import com.basic.naming.NamedThreadFactory;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class SchedulingExecutorFirst {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Thread " + Thread.currentThread().getName() + " starts");

        //ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory());

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3,new NamedThreadFactory());

        System.out.println("Current time " + LocalDateTime.now());

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.schedule(new ScheduleTaskB(2000L, "1"), 4, TimeUnit.SECONDS);

        ScheduledFuture<Integer> scheduledFuture1 = scheduledExecutorService.schedule(new ValueReturningSchedulingTaskCallable(10, 20,2000L,"2"), 6, TimeUnit.SECONDS);

        scheduledExecutorService.schedule(new ScheduleTaskB(2000L, "3"), 8, TimeUnit.SECONDS);

        ScheduledFuture<Integer> scheduledFuture2 = scheduledExecutorService.schedule(new ValueReturningSchedulingTaskCallable(10, 20,2000L,"4"), 10, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();

       // scheduledFuture.cancel(Boolean.TRUE);
        //scheduledFuture1.cancel(Boolean.TRUE);

        System.out.println("The return values are "+scheduledFuture1.get()+" "+ scheduledFuture2.get()+" "+scheduledFuture.get() );//if task are cacelled CancellationException will be thrown

        System.out.println("Thread " + Thread.currentThread().getName() + " ends");

    }
}
