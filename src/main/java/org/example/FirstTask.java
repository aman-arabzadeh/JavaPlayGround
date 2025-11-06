package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/*
    Running task downloading files
 */
public record FirstTask(int total) implements Callable<String> {

    @Override
    public String call() {

        String threadName = Thread.currentThread().getName();
        System.out.printf("%s -- Starting download task...%n", threadName);

        for (int i = 1; i <= total; i++) {
            System.out.printf("%s - Downloading chunk %d/%d%n", threadName, i, total);
            try {
                TimeUnit.MILLISECONDS.sleep(1000 + (long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("%s - Download complete!%n", threadName);
        return "Download successful from " + threadName;
    }
}
