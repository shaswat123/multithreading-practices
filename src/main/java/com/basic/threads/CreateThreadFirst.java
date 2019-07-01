package com.basic.threads;

import java.util.concurrent.TimeUnit;

public class CreateThreadFirst {

    public static void main(String[] args) {

        System.out.println("Main thread starts here");

        Thread t1= new CreateThread();
        Thread t2 = new CreateThread();

        System.out.println("Main thread ends here");

    }


}

 class CreateThread extends Thread{

    private static Integer count=0;
    private Integer id;

     @Override
     public void run() {


         for(Integer i=0;i<=10;i++){

             System.out.println("<"+id+"> TICK TICK"+i);
             try{
                 TimeUnit.MILLISECONDS.sleep(200);
             }catch (InterruptedException in){

             }
         }




     }

     public CreateThread() {
         this.id = ++count;
         this.start();
     }
 }
