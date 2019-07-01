package com.basic.threads;

public class CreateThreadFifth {

    public static void main(String[] args) {

        System.out.println("The main thread starts here");

        new Thread(new Runnable() {
            public void run() {

                for (int i=0;i<10;i++){

                    System.out.println("Tick "+i);
                }

            }
        }).start();

        System.out.println("The main thread stops here");

    }
}
