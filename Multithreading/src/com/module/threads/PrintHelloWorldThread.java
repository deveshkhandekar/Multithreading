package com.module.threads;

public class PrintHelloWorldThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World"+Thread.currentThread().getName());
    }
}
