package com.basic.retvalues;

import com.basic.exceuters.LoopTaskA;
import com.basic.naming.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturningValueUsingExecutorsFirstWay {

    public static void main(String[] args) throws Exception {

        System.out.println("Thread " + Thread.currentThread().getName() + " starts");

        ValueReturningTaskCallable valueReturningTaskCallable1 = new ValueReturningTaskCallable(10, 20, 2000L, "1");
        ValueReturningTaskCallable valueReturningTaskCallable2 = new ValueReturningTaskCallable(30, 40, 1000L, "2");
        ValueReturningTaskCallable valueReturningTaskCallable3 = new ValueReturningTaskCallable(50, 60, 500L, "3");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
        Future<Integer> result1 = executorService.submit(valueReturningTaskCallable1);
        Future<Integer> result2 = executorService.submit(valueReturningTaskCallable2);
        Future<Integer> result3 = executorService.submit(valueReturningTaskCallable3);

        System.out.println("First result " + result1.get());
        System.out.println("Second result " + result2.get());
        System.out.println("Third result " + result3.get());


        Future<?> result4 = executorService.submit(new LoopTaskA(4));

        Future<String> result5 = executorService.submit(new LoopTaskA(5), "Hello");

        System.out.println("Fourth result "+result4.get());
        System.out.println("Fifth result "+result5.get());
        System.out.println("Thread " + Thread.currentThread().getName() + " ends");

        executorService.shutdown();

    }
}
