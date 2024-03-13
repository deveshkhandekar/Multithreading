package com.module.threads;

public class NumberPrinterThread implements Runnable {
    private Integer number;

    public NumberPrinterThread(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Number to print " + this.number + " :: " + Thread.currentThread().getName());
    }
}
