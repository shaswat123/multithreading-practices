package com.basic.threads;

import java.util.concurrent.TimeUnit;

public class CreateThreadSecond {

    public static void main(String[] args) {

        System.out.println("Main thread starts here");

        Thread t1 = new CreateThreadSec();
        t1.start();
        Thread t2 = new CreateThreadSec();
        t2.start();

        System.out.println("Main thread ends here");

    }
}

class CreateThreadSec extends Thread {

    private static Integer count = 0;
    private Integer id;

    @Override
    public void run() {


        for (Integer i = 0; i <= 10; i++) {

            System.out.println("<" + id + "> TICK TICK" + i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException in) {

            }
        }


    }

    public CreateThreadSec() {
        this.id = ++count;

    }
}
