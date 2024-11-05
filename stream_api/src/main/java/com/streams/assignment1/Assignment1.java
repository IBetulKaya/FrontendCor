package com.streams.assignment1;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment1 {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1,2,3,4,9,5,6,7,8);

        // A stream can be used only once
        // Create a new stream everytime
        // Search on Google for hints

        // 1 Print each number in the stream
        stream.forEach(System.out::println);
        // 2 Print all the squares of the elements in the stream
        stream = Stream.of(1,2,3,4,9,5,6,7,8);
        stream.map(n->n*n)
                .forEach(System.out::println);
        // 3 Print all elements > 5 (use filter method)
        stream = Stream.of(1,2,3,4,9,5,6,7,8);
        stream.filter(n->n>5)
                .forEach(System.out::println);
        // 4 Add 10 to every element and print the result
        stream = Stream.of(1,2,3,4,9,5,6,7,8);
        stream.map(n->n+10)
                .forEach(System.out::println);

        // 5 Create a List of Integers from the stream
        stream = Stream.of(1,2,3,4,9,5,6,7,8);
        stream.toList()
                .forEach(System.out::println);
        // 6 Use the map method to transform the stream to a stream of Strings and print them
        stream = Stream.of(1,2,3,4,9,5,6,7,8);
        Stream<String> stringStream = stream.map(n->n.toString());
        stringStream.forEach(System.out::println);
        // 7 print the maximum number in the stream
        System.out.println("/////////");
        stream = Stream.of(1,2,3,4,9,5,6,7,8);

        Optional<Integer> max = stream
                .max(Integer::compareTo);
        max.ifPresent(System.out::println);
        // 8 print numbers as a comma separated string: 1,2,3,4,5,6,7,8
        stream = Stream.of(1,2,3,4,9,5,6,7,8);
        String result =stream
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(result);
    }
}
