package com.basic.waiting;

import com.basic.naming.LoopTaskB;

public class JoinThreadsFirst {

    public static void main(String[] args) throws InterruptedException{

        String currentThread= Thread.currentThread().getName();

        System.out.println("Thread "+currentThread +" starts");

        Thread t1 = new Thread(new LoopTaskB(1),"Custom Thread-1");
        Thread t2 = new Thread(new LoopTaskB(2),"Custom Thread-2");
        Thread t3 = new Thread(new LoopTaskB(3),"Custom Thread-3");
        Thread t4 = new Thread(new LoopTaskB(4),"Custom Thread-4");


        t1.start();

        t3.start();
        t4.start();

        //blocks the main thread or thread that joins with other thread
        t1.join();

        System.out.println(currentThread + " joins with thread "+ t1.getName());

        t2.start();

        t2.join();

        System.out.println(currentThread + " joins with thread "+ t2.getName());

        t3.join();

        System.out.println(currentThread + " joins with thread "+ t3.getName());

        t4.join();

        System.out.println(currentThread + " joins with thread "+ t4.getName());




        System.out.println("Thread "+currentThread +" ends");


    }
}
