package com.basic.terminate;

import com.basic.naming.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TerminateExecutorSecond {

    public static void main(String[] args) throws Exception {

        System.out.println("Thread "+Thread.currentThread().getName() + " starts");

        LoopTaskH loopTaskH= new LoopTaskH(1,3000L,20L);
        LoopTaskF loopTaskF = new LoopTaskF(2,3000L);

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        Future<? > factorial = executorService.submit(loopTaskH);
        Future<? > runnableTask = executorService.submit(loopTaskF);

        executorService.shutdown();

        TimeUnit.MILLISECONDS.sleep(3000);

        System.out.println("Thread "+Thread.currentThread().getName() + " invoking cancel");

        factorial.cancel(Boolean.TRUE);
        runnableTask.cancel(Boolean.TRUE);

        System.out.println("Thread "+Thread.currentThread().getName() + " Ends");


    }



}
