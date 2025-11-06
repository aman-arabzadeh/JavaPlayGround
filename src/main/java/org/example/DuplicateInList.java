package org.example;

import java.util.Collections;
import java.util.List;

/*
 * Duplicates in list using helper record
 */
public class DuplicateInList {
    public static void main(String[] args) {

        var data = List.of(1, 2, 3, 3, 3, 4, 5, 2, 2, 2);
        var n = Collections.frequency(data,2);
        System.out.println(n);


        record Duplicate(int value, long frequency) {
            public boolean hasDuplicate() {
                return frequency > 1;
            }
        }

        var duplicates = data.stream()
                .distinct()
                .map(v -> new Duplicate(v, Collections.frequency(data, v)))
                .filter(Duplicate::hasDuplicate)
                .toList();

        duplicates.forEach(System.out::println);
    }
}
