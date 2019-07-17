package com.basic.uncaughtExceptions;

import com.basic.naming.NamedThreadFactory;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryWithExceptionHandler extends NamedThreadFactory {

    public Thread newThread(Runnable r) {

        Thread t = super.newThread(r);

        t.setUncaughtExceptionHandler(new ThreadExceptionHandler());

        return t;
    }
}
