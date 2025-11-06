package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
/*
*  Prints Emojis
 */
public class Emojis {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public static void add(String s) {
        System.out.print(s);
        if (atomicInteger.incrementAndGet() % 10 == 0) {
            System.out.println();
        }
    }


    public static void main(String[] args) {

        IntStream.range(0, Character.MAX_CODE_POINT)
                .filter(Character::isEmoji)
                .mapToObj(Character::toChars)
                .map(String::new)
                .forEach(Emojis::add);

        System.out.println("\n\n--- SECOND VERSION LOOP---\n");

        int line = 0;
        for (int cp = 0; cp < Character.MAX_CODE_POINT; cp++) {
            if (Character.isEmoji(cp)) {
                if (line++ % 10 == 0) {
                    System.out.println();
                }
                System.out.print(new String(Character.toChars(cp)));
            }
        }
    }
}
