package org.example.thread;

public class MessageBuffer {
    private String message;
    private boolean hasMessage = false;

    public synchronized String consume() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        hasMessage = false;
        notifyAll();
        return message;
    }

    public synchronized void produce(String msg) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        this.message = msg;
        hasMessage = true;
        notifyAll();
    }
}
