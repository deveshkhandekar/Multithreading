package com.module.threads;

public class PrintHelloWorldThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World " + Thread.currentThread().getName());
        doSomeThing();
    }

    public void doSomeThing() {
        System.out.println("Do something : " + Thread.currentThread().getName());
    }
}
