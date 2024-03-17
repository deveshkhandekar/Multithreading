package com.module.threads.mergesort;

import java.util.List;
import java.util.concurrent.Callable;

public class Sorter implements Callable<List<Integer >> {
    private List<Integer> arrayToSort;

    public Sorter(List<Integer> arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    @Override
    public List<Integer> call() throws Exception {
        return null;
    }
}
