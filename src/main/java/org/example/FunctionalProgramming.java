package org.example;


import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface FunctionalProgramming {

    static Integer sumIf(Predicate<Integer> condition, List<Integer> data) {
        return data.stream()
                .filter(condition)
                .mapToInt(Integer::intValue)
                .sum();
    }

    static void main(String... args) {
        Function<String, String> trim = String::trim;
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> replaceSpecialChars = str -> str.replaceAll("[^\\p{Alnum}\\s]", "");
        Function<String, String> clean = trim.andThen(toUpperCase).andThen(replaceSpecialChars);
        String res = clean.apply("  Hello //( World!!=? \n Answer ?=) is 42.");
        System.out.println(res);



        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sumEven = sumIf(n -> n % 2 == 0, numbers);
        Integer sumOdd = sumIf(n -> n % 2 == 1, numbers);
        int totalSum = sumEven + sumOdd;

        System.out.println("Even sum: " + sumEven);
        System.out.println("Odd sum: " + sumOdd);
        System.out.println("Total sum: " + totalSum);
        List<Boolean> flags = List.of(true, false, true, false, true, true, false, true, false, true);
        Integer sumSelected = sumIf((n) -> flags.get(n - 1), numbers);
        System.out.println(sumSelected);

    }
}
