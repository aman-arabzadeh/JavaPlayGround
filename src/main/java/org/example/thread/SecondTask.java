package org.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/*
* Second Task Connecting to server and doing something running script could be also.
*
 */
public record SecondTask(int total) implements Callable<String> {


    @Override
    public String call() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s -- Connecting to the server...%n", threadName);

        for (int i = 1; i <= total; i++) {
            System.out.printf("%s - Reading file %d/%d%n", threadName, i, total);
            try {
                TimeUnit.MILLISECONDS.sleep(1000 + (long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("%s - All %d files read successfully!%n", threadName, total);
        return "Server reading completed from " + threadName;
    }
}
