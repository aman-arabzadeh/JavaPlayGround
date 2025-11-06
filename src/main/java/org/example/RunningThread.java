package org.example;

import java.util.concurrent.*;
/*
* Running the tasks async in background and returning the res after completion using a fixed thread pool of 2 threads
*/
public class RunningThread {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

            CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(
                    () -> {
                        try {
                            return new FirstTask(10).call();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }, executor
            );


            CompletableFuture<String> secondTask = CompletableFuture.supplyAsync(
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
