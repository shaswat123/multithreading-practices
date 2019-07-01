package com.basic.threads;

import java.util.concurrent.TimeUnit;

public class CreateThreadFourth {

    public static void main(String[] args) {

        System.out.println("Main thread starts here");

        Thread t1=new Thread(new CreateThreadFou());
        t1.start();
        Thread t2 = new Thread(new CreateThreadFou());
        t2.start();


        System.out.println("Main thread ends here");

    }
}

class CreateThreadFou implements Runnable {

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

    public CreateThreadFou() {
        this.id = ++count;


    }
}
