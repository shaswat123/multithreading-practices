package com.basic.exceuters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTwoCachedThreadPool {

    public static void main(String[] args) {

        System.out.println("Main thread starts here");

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new LoopTaskA(1));
        executorService.execute(new LoopTaskA(2));
        executorService.execute(new LoopTaskA(3));
        executorService.execute(new LoopTaskA(4));
        executorService.execute(new LoopTaskA(5));
        executorService.execute(new LoopTaskA(6));

        executorService.shutdown();
        System.out.println("Main thread ends here");
    }
}
