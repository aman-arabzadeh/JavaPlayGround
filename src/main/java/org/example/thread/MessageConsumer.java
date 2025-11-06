package org.example.thread;


public record MessageConsumer(MessageBuffer messageBuffer, int delayMillis) implements Runnable {
    @Override
    public void run() {
        var message = "";
        do {
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted.");
            }
            message = messageBuffer.consume();
            System.out.printf("Consumed -> The massage is  %s%n ", message);

        } while (!"finished".equalsIgnoreCase(message));

    }
}


