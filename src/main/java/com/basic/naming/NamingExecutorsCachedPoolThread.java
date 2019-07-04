package com.basic.naming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NamingExecutorsCachedPoolThread{

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
        executorService.execute(new LoopTaskB(1));
        executorService.execute(new LoopTaskB(2));
        executorService.execute(new LoopTaskB(3));
        executorService.execute(new LoopTaskB(4));

        TimeUnit.SECONDS.sleep(15);

        executorService.execute(new LoopTaskB(5));
        executorService.execute(new LoopTaskB(6));
        executorService.execute(new LoopTaskB(7));
        executorService.execute(new LoopTaskB(8));

        executorService.shutdown();

    }


}
