package com.module.threads.helper;

public class Value {
    public int value = 0;

    public synchronized int incrementValue(int i){
        this.value += i;
        return this.value;
    }

    public synchronized int decrementValue(int i){
        this.value -= i;
        return this.value;
    }

}
