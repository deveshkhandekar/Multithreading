package com.module.threads;

import com.module.threads.helper.Store;

public class ConsumerThread  implements  Runnable{

    private Store store;

    public ConsumerThread(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            synchronized (store) {
                if (this.store.getItems().size() > 0) {
                    this.store.removeItem();
                }
            }
        }
    }
}
