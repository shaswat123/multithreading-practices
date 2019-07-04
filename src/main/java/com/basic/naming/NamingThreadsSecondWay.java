package com.basic.naming;

import java.sql.SQLOutput;

public class NamingThreadsSecondWay {

    public static void main(String[] args) {

        Thread.currentThread().setName("MainThread");
        System.out.println("The main thread start here "+Thread.currentThread().getName());

        new Thread(new LoopTaskB(1),"customThread").start();

        Thread anotherThread= new Thread(new LoopTaskB(2));
       // anotherThread.setName("Another Thread");
        anotherThread.start();

        anotherThread.setName("Another Thread");




    }

}
