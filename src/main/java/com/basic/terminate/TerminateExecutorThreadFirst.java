package com.basic.terminate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TerminateExecutorThreadFirst {

    public static void main(String[] args) throws Exception {

        System.out.println("Thread " + Thread.currentThread().getName() + " starts here ");

        LooptaskG looptaskG = new LooptaskG(1, 3000L, 20L);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Long> factorialValue = executorService.submit(looptaskG);

        executorService.shutdown();

        TimeUnit.MILLISECONDS.sleep(3000);

        looptaskG.cancel();
        System.out.println("Factorial value is " + factorialValue.get());

        System.out.println("Thread " + Thread.currentThread().getName() + " Ends");


    }
}
