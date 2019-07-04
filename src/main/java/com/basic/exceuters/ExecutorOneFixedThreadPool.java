package com.basic.exceuters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorOneFixedThreadPool {

    public static void main(String[] args) {
        System.out.println("Main thread starts here");

        ExecutorService executorService= Executors.newFixedThreadPool(3);

        executorService.execute(new LoopTaskA(1));
        executorService.execute(new LoopTaskA(2));
        executorService.execute(new LoopTaskA(3));
        executorService.execute(new LoopTaskA(4));
        executorService.execute(new LoopTaskA(5));
        executorService.execute(new LoopTaskA(6));


        executorService.shutdown();

       // executorService.execute(new LoopTaskA());

        System.out.println("Main thread ends here");
    }


}
