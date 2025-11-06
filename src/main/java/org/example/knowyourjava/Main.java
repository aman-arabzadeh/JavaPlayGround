package org.example.knowyourjava;

import java.util.ArrayList;
import java.util.List;


public interface Main {
     static void main(String... args) {


        // List: remove by index or value
        // List<Integer> dataList = new ArrayList<>(List.of(1,2,3,4,5));

        // Collection: remove by value only
        // Collection<Integer> dataList = new ArrayList<>(List.of(1,2,3,4,5,89));

        // var: type inferred (ArrayList)
        var dataList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5, 89));

        dataList.remove(2);
        dataList.removeIf(d -> d == 5);
        System.out.println(dataList);


        // List<Integer> numbers = Arrays.asList(1,2,3); // Size is constant add, set, won't work
        List<Integer> numbers = List.of(1, 2, 3); //  List.of() concrete same go   // Map.of(), Set.of


        System.out.println(numbers.getClass());

        try {
            numbers.add(23); // array.asList() is not expandable constant size be careful.
        } catch (Exception ex) {
            System.out.println("Add not supported " + ex.getMessage());
        }
        try {
            numbers.set(2, 2);
        } catch (Exception ex) {
            System.out.println("Set not supported ");
        }


        List<String> names = List.of("Mona", "Lisa", "David", "John", "Sarah");
//        List<String> nameUpperCased = new ArrayList<>();
//        names.stream() || names.parallelStream() race conditions.
//                .map(String::toUpperCase)
//                .forEach(nameUpperCased::add); // side effects // It works sometimes


        List<String> nameUpperCased = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(names.size());
        System.out.println(nameUpperCased.size());


        // What output? think Lazy Evaluation
        int[] factor = new int[]{2};
        var sample = List.of(1, 2, 3);


        var stream = sample.stream()
                .map(x -> x * factor[0]);

        factor[0] = 0;
        stream.forEach(System.out::println);

    }
}