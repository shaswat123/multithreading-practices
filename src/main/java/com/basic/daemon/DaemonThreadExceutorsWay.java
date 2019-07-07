package com.basic.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreadExceutorsWay {

    public static void main(String[] args) {

        ExecutorService executorService= Executors.newCachedThreadPool(new DaemonThreadfactory());

        executorService.execute(new LoopTaskC(1,2000L));
        executorService.execute(new LoopTaskC(2,1000L));
        executorService.execute(new LoopTaskC(3,500L));
        executorService.execute(new LoopTaskC(4,100L));


        executorService.shutdown();



    }

}
