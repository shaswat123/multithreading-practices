package com.basic.uncaughtExceptions;

public class TaskThrowinRunTimeException implements Runnable{


    public void run() {

        throw new RuntimeException();

    }
}
