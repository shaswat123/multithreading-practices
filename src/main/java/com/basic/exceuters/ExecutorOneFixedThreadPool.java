package com.basic.exceuters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorOneFixedThreadPool {

    public static void main(String[] args) {
        System.out.println("Main thread starts here");

        ExecutorService executorService= Executors.newFixedThreadPool(6);

        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());


        executorService.shutdown();

       // executorService.execute(new LoopTaskA());

        System.out.println("Main thread ends here");
    }


}
