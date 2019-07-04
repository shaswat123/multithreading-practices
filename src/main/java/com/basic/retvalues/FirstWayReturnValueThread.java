package com.basic.retvalues;

public class FirstWayReturnValueThread {

    public static void main(String[] args) {

        System.out.println("Thread " + Thread.currentThread().getName() + "starts");

        ValueReturningTask valueReturningTask1 = new ValueReturningTask(10, 20, 2000L, "1",new SumResultListener("1"));

        Thread t1 = new Thread(valueReturningTask1, "Custom-thread 1");


        ValueReturningTask valueReturningTask2 = new ValueReturningTask(30, 40, 1000L, "2",new SumResultListener("2"));

        Thread t2 = new Thread(valueReturningTask2, "Custom-thread 2");


        ValueReturningTask valueReturningTask3 = new ValueReturningTask(50, 60, 500L, "3",new SumResultListener("3"));

        Thread t3 = new Thread(valueReturningTask3, "Custom-thread 3");
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Thread "+Thread.currentThread().getName() +" Ends");
    }
}
