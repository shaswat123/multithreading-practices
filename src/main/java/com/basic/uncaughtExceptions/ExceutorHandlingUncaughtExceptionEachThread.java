package com.basic.uncaughtExceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceutorHandlingUncaughtExceptionEachThread {

    public static void main(String[] args) {

        System.out.println("Thread "+Thread.currentThread().getName() + "starts");

        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandler());

        executorService.execute(new TaskThrowinRunTimeException());
        executorService.execute(new TaskThrowinRunTimeException());
        executorService.execute(new TaskThrowinRunTimeException());
        executorService.execute(new TaskThrowinRunTimeException());

        executorService.shutdown();

        System.out.println("Thread "+Thread.currentThread().getName() + "ends");


    }

}
