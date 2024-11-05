package com.streams.assignment8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Assignment8 {

    public static void main(String[] args) throws IOException {

        // Create a stream of lines from file
        Stream<String> lines = Files.lines( Paths.get("src/main/resources/data.txt"));

        //  1
        //  Use method map to map each line to an array of Strings
        //  (this creates a stream of arrays)
        //  Use the filter method to get a stream of arrays of length 3
        //  Use the filter method to get a stream of arrays with first item > 15
        //  print contents of every array in the resulting stream


        //  2
        //  Use method map to map each line to an array of Strings
        //  Use the flatMap method to create a stream of Integers from the stream of arrays


    }
}
