package com.basic.terminate;

import java.util.concurrent.TimeUnit;

public class TerminatingBlockedThreads {

    public static void main(String[] args) throws Exception {

        System.out.println("Thread " + Thread.currentThread().getName() + " starts");

        LoopTaskF loop1 = new LoopTaskF(1, 3000L);
        LoopTaskF loop2 = new LoopTaskF(2, 3000L);
        LoopTaskF loop3 = new LoopTaskF(3, 3000L);

        Thread t1 = new Thread(loop1, "Custom-thread-1");
        t1.start();

        Thread t2 = new Thread(loop2, "Custom-thread-2");
        t2.start();

        Thread t3 = new Thread(loop3, "Custom-thread-3");
        t3.start();

        TimeUnit.MILLISECONDS.sleep(3000);

        System.out.println("Interrupting thread " + t1.getName());
        t1.interrupt();

        System.out.println("Interrupting thread " + t2.getName());
        t2.interrupt();

        System.out.println("Interrupting thread " + t3.getName());
        t3.interrupt();


        System.out.println("Thread " + Thread.currentThread().getName() + "stops");

    }

}
