package com.basic.terminate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoopTaskE implements Runnable {

    private volatile Integer id;


    public LoopTaskE(Integer id) {
        this.id = id;

    }


    public void run() {

        System.out.println("Task Id " + id + " Starting " + "With thread name " + Thread.currentThread().getName() + "is Daemon thread" + Thread.currentThread().isDaemon());

        for (int i = 10; ; i--) {
            System.out.println("Task Id " + id + " Tick " + i);
            doSomeWork();

            if(Thread.interrupted()){
                System.out.println("Thread "+ Thread.currentThread().getName() +" Interrupted and cancelling");

                break;
            }

        }

        System.out.println("Status of interrupted thread "+ Thread.currentThread().getName()+" "+Thread.interrupted());//false here as JVN reset the value

        System.out.println("Thread "+ Thread.currentThread().getName() +" Finished");


    }

    private void doSomeWork(){

        for(int i=0;i<2;i++){
            Collections.sort(generateDataSet());
        }


    }

    private List<Integer> generateDataSet(){

        List<Integer> intList = new ArrayList<Integer>();
        Random randonGenerator = new Random();

        for(int i=0;i<100000;i++){
            intList.add(randonGenerator.nextInt(100000));

        }

        return intList;

    }


}

