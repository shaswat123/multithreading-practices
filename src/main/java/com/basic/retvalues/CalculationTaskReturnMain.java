package com.basic.retvalues;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalculationTaskReturnMain {

    public static void main(String[] args) throws Exception {

        CalculationTaskCallableReturningBean bean1= new CalculationTaskCallableReturningBean(10,20,2000L,"TA-1");
        CalculationTaskCallableReturningBean bean2= new CalculationTaskCallableReturningBean(30,40,1000L,"TA-2");
        CalculationTaskCallableReturningBean bean3= new CalculationTaskCallableReturningBean(50,60,500L,"TA-3");

        ExecutorService executorService = Executors.newCachedThreadPool();

        CompletionService<TaskResult<String,Integer>> tasks= new ExecutorCompletionService<TaskResult<String, Integer>>(executorService);

        tasks.submit(bean1);
        tasks.submit(bean2);
        tasks.submit(bean3);

        for(Integer i=0;i<3;i++){

            System.out.println(tasks.take().get());


        }

        executorService.shutdown();

    }
}
