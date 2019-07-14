package com.basic.uncaughtExceptions;

public class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    public ThreadExceptionHandler(String handlerId) {
        this.handlerId = handlerId;
    }

    public ThreadExceptionHandler() {

    }

    private String handlerId;



    public void uncaughtException(Thread t, Throwable e) {

        System.out.println("Caught Exception in Thread "+t.getName()+" "+e);

    }
}
