package com.basic.daemon;

import com.basic.naming.NamedThreadFactory;

public class DaemonThreadfactory extends NamedThreadFactory {

    private static int count=0;

    @Override
    public Thread newThread(Runnable r) {
        Thread t1=  super.newThread(r);

        count++;
                if(count%2==0){
                    t1.setDaemon(Boolean.TRUE);
                }

                return  t1;

    }
}
