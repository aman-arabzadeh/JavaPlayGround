package org.example.emoji;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.lang.Character.toChars;

/*
 *  Prints Emojis neat
 */
public class Emojis {

    public static void printEmojis(IntStream emojiCodePoints, final int countPerLine) {
        final AtomicInteger counter = new AtomicInteger(0);

        for (int codePoint : emojiCodePoints.toArray()) {
            System.out.print(toChars(codePoint));
            if (counter.incrementAndGet() % countPerLine == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        //  wrap emoji code
        record Emoji(int code) {
            public String emojiName() {
                return Character.getName(code) != null ? Character.getName(code) : "Unknown";
            }

            public String emoji() {
                return String.valueOf(toChars(code));
            }

            @Override
            public String toString() {
                return "%s ---> %s".formatted(emojiName(), emoji());
            }
        }


        System.out.println("With description: ");
        IntStream.range(0, Character.MAX_CODE_POINT)
                .filter(Character::isEmoji)
                .mapToObj(Emoji::new)
                .forEach(System.out::println);

        System.out.println("\n\n--- Emojis   ---");

        IntStream stream = IntStream.range(0, Character.MAX_CODE_POINT)
                .filter(Character::isEmoji);
        printEmojis(stream, 61);
    }
}
