package com.streams.assignment2;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class Assignment2 {

    public static void main(String[] args) {

        System.out.println( getEncodedString("Muslum"));

        List<String> memberNames = new ArrayList<>();

        memberNames.add("Mahtab");
        memberNames.add("Hilal");
        memberNames.add("Mehmet");
        memberNames.add("Dmytro");
        memberNames.add("Emrah");
        memberNames.add("Mila");
        memberNames.add("Halil");
        memberNames.add("Samet");
        memberNames.add("Milad");
        memberNames.add("Jacky");
        memberNames.add("Amirhossein");

        // 1 Print all names that start with an 'M' or 'H'
        System.out.println("111111111");
        memberNames.stream()
                .filter(name -> name.startsWith("M") || name.startsWith("H"))
                .forEach(System.out::println);

        // 2 Print the names + lengths of the names
        System.out.println("222222222");
        memberNames.stream()
                .map(name -> name + " (" + name.length() + ")")
                .forEach(System.out::println);



        // 3 print all names converted to uppercase
        System.out.println("3333333333333");
        memberNames.stream()
                .map(name->name.toUpperCase())
                .forEach(System.out::println);

        // 4 count all names in the stream
        System.out.println("444444444");
        long result = memberNames.stream()
                .count();
        System.out.println(result);

        // 5 Find the first name that starts with an 'H'
        System.out.println("55555555555");
        Optional<String> name =memberNames.stream().filter(n -> n.startsWith("H"))
                .findFirst();
        System.out.println(name.get());
        // 6 Print the names, sorted alphabetically
        System.out.println("666666666");
        memberNames.stream()
                .sorted()
                .forEach(System.out::println);


        // 7 Print all Base64 Encoded names using (see below) method getEncodedString
        System.out.println("7777777777");
        memberNames.stream()
                .map(n->getEncodedString(n))
                .forEach(System.out::println);

    }

    private static String getEncodedString( String plainText){

        byte[] encodedBytes = Base64.getEncoder().encode(plainText.getBytes());
        return( new String(encodedBytes));

    }

}
