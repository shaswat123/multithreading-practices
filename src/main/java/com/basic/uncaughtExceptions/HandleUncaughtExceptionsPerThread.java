package com.basic.uncaughtExceptions;

public class HandleUncaughtExceptionsPerThread {

    public static void main(String[] args) {

        System.out.println("Thread "+Thread.currentThread().getName()+" starts");

        TaskThrowinRunTimeException task1 = new TaskThrowinRunTimeException();
        TaskThrowinRunTimeException task2 = new TaskThrowinRunTimeException();
        TaskThrowinRunTimeException task3 = new TaskThrowinRunTimeException();

        Thread thread1 = new Thread(task1,"Custom-Thread-1");
        Thread thread2 = new Thread(task1,"Custom-Thread-2");
        Thread thread3 = new Thread(task1,"Custom-Thread-3");

        thread1.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        thread2.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        thread3.setUncaughtExceptionHandler(new ThreadExceptionHandler("ID -3"));

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Thread "+Thread.currentThread().getName()+" ends");

    }
}
