package com.basic.naming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingExecutorsThread {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
        executorService.execute(new LoopTaskB((1)));
        executorService.execute(new LoopTaskB((2)));
        executorService.execute(new LoopTaskB((3)));

        executorService.shutdown();

    }
}
