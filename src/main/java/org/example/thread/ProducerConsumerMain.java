package org.example.thread;

import java.util.stream.IntStream;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        var message = """
                Hello,World,Java,Yahoo
                """;

        var buffer = new MessageBuffer();
        var producer = new Thread(new MessageProducer(buffer, message.split(","), 500));
        var consumer = new Thread(new MessageConsumer(buffer, 300));
        producer.start();
        consumer.start();
        try{
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        IntStream.range(0, 10)
                .mapToObj("%03d"::formatted)
                .forEach(System.out::println);

    }
}
