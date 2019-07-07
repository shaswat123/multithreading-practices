package com.basic.terminate;

import java.util.concurrent.TimeUnit;

public class TerminateThreadsFirstWay {

    public static void main(String[] args) throws Exception{

        System.out.println("The thread "+Thread.currentThread().getName() +" starts");

        LoopTaskD loop1= new LoopTaskD(1,3000L);
        LoopTaskD loop2= new LoopTaskD(2,3000L);
        LoopTaskD loop3= new LoopTaskD(3,3000L);

        Thread t1 = new Thread(loop1,"Custom-Thread-1");
        Thread t2 = new Thread(loop2,"Custom-Thread-2");
        Thread t3 = new Thread(loop3,"Custom-Thread-3");

        t1.start();
        t2.start();
        t3.start();

        TimeUnit.MILLISECONDS.sleep(3000);

        loop1.cancel();
        loop2.cancel();
        loop3.cancel();

        System.out.println("The thread "+Thread.currentThread().getName() +" ends");


    }

}
