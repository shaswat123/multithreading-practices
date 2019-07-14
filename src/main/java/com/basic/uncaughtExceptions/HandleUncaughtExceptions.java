package com.basic.uncaughtExceptions;

public class HandleUncaughtExceptions {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+" thread starts");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("default handler"));

        new Thread(new TaskThrowinRunTimeException(),"thread-1").start();
        new Thread(new TaskThrowinRunTimeException(),"thread-2").start();

        System.out.println(Thread.currentThread().getName() +" thread ends");

    }


}
