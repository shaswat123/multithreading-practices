package com.basic.waiting;

import com.basic.naming.NamedThreadFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class JoiningExecutorsThread {

    public static void main(String[] args) throws  InterruptedException{

        System.out.println("Thread "+Thread.currentThread().getName()+ " starts");

        //any two task or two specific task
        CountDownLatch latch = new CountDownLatch(2);


        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        executorService.execute(new CountDownLatchTask(1,5000L,null));
        executorService.execute(new CountDownLatchTask(2,6000L,latch));
        executorService.execute(new CountDownLatchTask(3,7000L,latch));
        executorService.execute(new CountDownLatchTask(4,8000L,null));

        executorService.shutdown();


        latch.await();
        System.out.println("ALl threads execution completed "+Thread.currentThread().getName() +" continues ");




        System.out.println("Thread "+Thread.currentThread().getName()+ " ends");
    }
}
