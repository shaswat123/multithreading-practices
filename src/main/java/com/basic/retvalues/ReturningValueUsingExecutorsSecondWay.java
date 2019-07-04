package com.basic.retvalues;

import com.basic.exceuters.LoopTaskA;
import com.basic.naming.NamedThreadFactory;

import java.util.concurrent.*;

//Process the task In order of completion
public class ReturningValueUsingExecutorsSecondWay {

    public static void main(String[] args) throws Exception {

        System.out.println("Thread " + Thread.currentThread().getName() + " starts");

        ValueReturningTaskCallable valueReturningTaskCallable1 = new ValueReturningTaskCallable(10, 20, 2000L, "1");
        ValueReturningTaskCallable valueReturningTaskCallable2 = new ValueReturningTaskCallable(30, 40, 1000L, "2");
        ValueReturningTaskCallable valueReturningTaskCallable3 = new ValueReturningTaskCallable(50, 60, 500L, "3");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        CompletionService<Integer> tasks = new ExecutorCompletionService<Integer>(executorService);


        tasks.submit(valueReturningTaskCallable1);
        tasks.submit(valueReturningTaskCallable2);
        tasks.submit(valueReturningTaskCallable3);

        tasks.submit(new LoopTaskA(5), 1234);

        executorService.shutdown();

        for (Integer i = 0; i < 4; i++) {

            System.out.println("Result " + tasks.take().get());//take method blocks when there is no task at completion.Throws Interrupted exception
        }


        System.out.println("Thread " + Thread.currentThread().getName() + " ends");


    }
}
