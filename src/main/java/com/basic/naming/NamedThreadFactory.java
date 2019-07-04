package com.basic.naming;

import javax.print.attribute.standard.MediaSize;
import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {

    private static Integer count=0;
    private static final String NAME="CustomThread ";


    public Thread newThread(Runnable r) {
        Thread t =new Thread(r, NAME+ ++count);
        return  t;
    }
}
