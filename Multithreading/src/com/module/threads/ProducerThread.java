package com.module.threads;

import com.module.threads.helper.Store;

public class ProducerThread implements Runnable{
    private Store store;

    public ProducerThread(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            synchronized (store){
                if (this.store.getItems().size() < this.store.getMaxSize()){
                    this.store.addItem();
                }
            }
        }
    }
}
