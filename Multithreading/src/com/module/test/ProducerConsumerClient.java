package com.module.test;

import com.module.threads.ConsumerThread;
import com.module.threads.ProducerThread;
import com.module.threads.helper.Store;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerClient {
    public static void main(String[] args) {

        //Approach 1 - Producer : Consumer problem
        ExecutorService executorService = Executors.newCachedThreadPool();
        Store store = new Store(5);
        for(int i=1; i<=8; i++){
            executorService.execute(new ProducerThread(store));
        }

        for(int i=1; i<=20; i++){
            executorService.execute(new ConsumerThread(store));
        }
    }
}
