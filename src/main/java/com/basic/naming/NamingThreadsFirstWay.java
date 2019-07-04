package com.basic.naming;

public class NamingThreadsFirstWay {

    public static void main(String[] args) {

        System.out.println("Main thread starts here Name:-"+Thread.currentThread().getName());

        new Thread(new LoopTaskB(1)).start();

        Thread newThread = new Thread(new LoopTaskB(2));

        newThread.start();

        System.out.println("Main thread starts here Name:-"+Thread.currentThread().getName());

    }
}
