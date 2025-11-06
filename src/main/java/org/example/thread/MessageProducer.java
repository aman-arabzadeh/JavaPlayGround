package org.example.thread;

public record MessageProducer(MessageBuffer messageBuffer, String[] messages, int delayMillis) implements Runnable {

    @Override
    public void run() {
        try {
            for (String msg : messages) {
                messageBuffer.produce(msg);
                System.out.println("Produced: " + msg);
                Thread.sleep(delayMillis);
            }
            messageBuffer.produce("finished");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer interrupted.");
        }
    }
}
