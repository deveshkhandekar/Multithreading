package com.module.threads;

import com.module.threads.helper.Value;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class SubtractorThread implements Callable<Void> {

    private Value v;
    private Lock lock;  // -->Approach 2

    public SubtractorThread(Value v) {
        this.v = v;
    }

    public SubtractorThread(Value v, Lock lock) {
        this.v = v;
        this.lock = lock;  // -->Approach 2
    }

    @Override
    public Void call() throws Exception {
        for(int i=1; i<=5000000; i++){
            System.out.println("Subtractor got the lock : "+Thread.currentThread().getName() +" : "+i);
            if(Objects.nonNull(this.lock))
                this.lock.lock();  // -->Approach 2

//            Critical Section
//            synchronized (this.v){ // --> Approach 3
//                this.v.value -= i;
//            }
            v.decrementValue(i); //--> Approach 4

            if(Objects.nonNull(this.lock))
                this.lock.unlock();  // -->Approach 2
        }
        return null;
    }
}
