package com.module.threads.helper;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int maxSize = 0;
    private List<Object> items;


    public Store(int maxSize) {
        this.items = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Object> getItems() {
        return items;
    }

    public  void addItem(){
        this.items.add(new Object());
        System.out.println("Producer produced item : Current Size :: "+this.items.size());
    }

    public void removeItem(){
        this.items.remove(this.items.size()-1);
        System.out.println("Consumer consumed item : Current Size :: "+this.items.size());
    }
}
