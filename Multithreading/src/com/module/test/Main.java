package com.module.test;

import com.module.threads.NumberPrinterThread;
import com.module.threads.PrintHelloWorldThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {

        PrintHelloWorldThread r1 = new PrintHelloWorldThread();
        Thread thread1 = new Thread(r1);
        thread1.start();
        System.out.println("INSIDE MAIN FUNCTION : " + Thread.currentThread().getName());
//        OUTPUT:
//        Hello World Thread-0
//        INSIDE MAIN FUNCTION : main
//        Do something : Thread-0
//        Here if its running is different cores then its parallelism
//        And if it's running in same core then its concurrency


//        The number of threads created are "n" so the CPU utilization is too high.
//        CPU Utilization goes high due to "n" number of thread creation
//        CPU utilization almost goes upto 100%
        for (int i = 0; i < 1000000; i++) {
            NumberPrinterThread r2 = new NumberPrinterThread(i);
            Thread thread = new Thread(r2);
            thread.start();
        }


//        So as an alternative we can make use of Threadpool
//        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(100); // This is used the create fixed number of threads and execute the tasks into fixed pool -- multiple tasks will be kept waiting
        ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();//This will allow threads creation for the waiting tasks. The created number of threads will be reused. No tasks will be kept waiting
        for (int i = 0; i < 1000000; i++) {
            NumberPrinterThread r2 = new NumberPrinterThread(i);
//            fixedThreadPool.execute(r2);
            cachedThreadPool.execute(r2);
        }

//        Shut-downing is important else it won't allow to exit
        fixedThreadPool.shutdown();
        cachedThreadPool.shutdown();

    }
}