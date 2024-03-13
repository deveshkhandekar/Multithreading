package com.module.test;

import com.module.threads.PrintHelloWorldThread;

public class Main {
    public static void main(String[] args) {

        PrintHelloWorldThread thread = new PrintHelloWorldThread();
        thread.run();
    }
}