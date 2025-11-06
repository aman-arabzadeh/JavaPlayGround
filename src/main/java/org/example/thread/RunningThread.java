package org.example.thread;

import java.util.concurrent.*;
/*
* Running the tasks async in background and returning the res after completion
*/
public class RunningThread {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

            var firstTask = CompletableFuture.supplyAsync(
                    () -> {
                        try {
                            return new FirstTask(10).call();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }, executor
            );


            var secondTask = CompletableFuture.supplyAsync(
                    () -> {
                        try {
                            return new SecondTask(10).call();
                        } catch (Exception exception) {
                            throw new RuntimeException(exception);
                        }
                    }, executor
            );

           CompletableFuture.allOf(
                    firstTask.thenAccept(result -> System.out.println("Result of firstTask: " + result)),
                    secondTask.thenAccept(result -> System.out.println("Result of secondTask: " + result))
            ).join();

            System.out.println("All tasks completed.");

        }
    }
}
