package com.module.test;

import com.module.threads.AdderThread;
import com.module.threads.SubtractorThread;
import com.module.threads.helper.Value;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainAdderSubtractorClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

//        Approach 1 - without using any locks normal approach gives non-zero value.
//        Value v = new Value();
//        AdderThread add = new AdderThread(v);
//        SubtractorThread sub  = new SubtractorThread(v);
//        Future<Void> submit = executorService.submit(add);
//        Future<Void> submit2 = executorService.submit(sub);
//        submit.get();
//        submit2.get();

//        We don't always get the expected value which is zero.
//        System.out.println(v.value);


//        Approach 2 - Using Locks - Mutex approach
//        Lock lock = new ReentrantLock();
//        Value v = new Value();
//        Will pass the same lock in both the Threads
//        AdderThread add = new AdderThread(v, lock);
//        SubtractorThread sub  = new SubtractorThread(v, lock);
//
//        Future<Void> submit = executorService.submit(add);
//        Future<Void> submit2 = executorService.submit(sub);
//        submit.get();
//        submit2.get();
//        System.out.println(v.value);

//        Approach - 3 - Enhancement of Approach 2 - Using Synchronized keyword
//        Instead of using explicit locks we can make use of implicit locks which java provides
//        i.e we can lock objects itself by using "synchronized" keyword

//        Value v = new Value();
//        AdderThread add = new AdderThread(v);
//        SubtractorThread sub  = new SubtractorThread(v);
//
//        Future<Void> submit = executorService.submit(add);
//        Future<Void> submit2 = executorService.submit(sub);
//        submit.get();
//        submit2.get();
//        System.out.println(v.value);

//        Approach - 4 - Using Synchronized methods
//        Here the idea is such that once a method is synchronized and if it's called then the lock will be taken on the object from where its called
        Value v = new Value();
        AdderThread add = new AdderThread(v);
        SubtractorThread sub  = new SubtractorThread(v);

        Future<Void> submit = executorService.submit(add);
        Future<Void> submit2 = executorService.submit(sub);
        submit.get();
        submit2.get();
        System.out.println(v.value);

        executorService.shutdownNow();
    }
}
