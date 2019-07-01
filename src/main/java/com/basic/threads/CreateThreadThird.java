package com.basic.threads;

import java.util.concurrent.TimeUnit;

public class CreateThreadThird {

    public static void main(String[] args) {

        System.out.println("Main thread starts here");

         new CreateThreadThr();
         new CreateThreadThr();


        System.out.println("Main thread ends here");

    }

}

class CreateThreadThr implements Runnable {

    private static Integer count = 0;
    private Integer id;


    public void run() {


        for (Integer i = 0; i <= 10; i++) {

            System.out.println("<" + id + "> TICK TICK" + i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException in) {

            }
        }


    }

    public CreateThreadThr() {
        this.id = ++count;
        new Thread(this).start();

    }

}
