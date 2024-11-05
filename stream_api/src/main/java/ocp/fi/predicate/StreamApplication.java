package ocp.fi.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamApplication {

    public static void main(String[] args) {

        List<Dj> djs = new ArrayList<>();

        djs.add( new Dj("Kevin", 23));
        djs.add( new Dj("Pete", 34));

        // use Stream.anyMatch method to test if name 'Kevin' is in the list of Djs
        //
        // You can use the map method also to map the stream of Djs
        // to a stream of Strings (names)

        boolean contains = djs.stream()
                .anyMatch( dj -> dj.getName().equals("Kevin"));

        System.out.println(contains);

        contains = djs.stream()
                .anyMatch( dj -> dj.getName().equals("Joan"));

        System.out.println(contains);

        // Using the map method, which maps a stream item Dj to a stream item String (the name)
        contains = djs.stream()
                .map( dj -> dj.getName())     // Dj is the stream element
                .anyMatch( s -> s.equals("Pete")); // String is now the stream element

        // Example of how to use the findFirst method
        Optional<Dj> dj = djs.stream()
                .filter((Dj d) -> d.getName().equalsIgnoreCase("Kevin"))
                .findFirst();

        System.out.println(contains);

    }
}



