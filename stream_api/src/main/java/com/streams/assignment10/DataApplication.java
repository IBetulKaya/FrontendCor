package com.streams.assignment10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class DataApplication {

    public static void main(String[] args) throws IOException {

        // Extract all files in data.zip in folder C:\Users\<username>\data
        // one of the files has a line that contains a string:
        //       34567899999999876543
        // Find the file that contains this string
        DataApplication dataApplication = new DataApplication();

        Stream<Path> pathStream = Files.list( Paths.get("C:/Users/<username>/data"));

        // Note:
        // We start with a stream of Paths (files).
        // the map function maps one item of the stream to a single other item.
        // I.e:    "2","3","4","5","6"  is mapped to 2,3,4,5
        // In our case the result of method dataApplication.getAllLines is a stream of Strings for every Path item
        // So, every Path is mapped to a stream which is not a single item. We must use the flatMap to
        // 'flatten' the returned streams.
        // Stream(Path1,Path2,Path2) --> getAllLines( Path1,Path2,Path2) --> Stream1<String>,Stream2<String>,Stream3<String>
        // flatMap( Stream1<String>,Stream2<String>,Stream3<String>) --> Stream<String> = String1,String2,String3,...
        // compare to putting the elements of multiple Lists into one single list

    }

    private Stream<String> getAllLines(Path path){

        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines.stream();
    }

}
