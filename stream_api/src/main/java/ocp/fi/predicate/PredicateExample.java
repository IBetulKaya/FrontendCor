package ocp.fi.predicate;

import ocp.fi.lamp.Lamp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    Predicate predicate;    // Here, just to inspect this Functional Interface (select type and ctrl+B)

    public static void main(String[] args) {

        Predicate<String> predicate = (s) -> s.startsWith("A");
        boolean startsWithA = PredicateExample.doSomethingWithPredicate("AVVVVVVV", predicate);
        System.out.println(startsWithA);

        Predicate<Integer> predicate2 = (s) -> s > 0;
        boolean greaterThanZero = PredicateExample.doSomethingWithPredicate(-8, predicate2);
        System.out.println(greaterThanZero);

        Predicate<Lamp> predicate3 = (s) -> s.isOn();
        Lamp lamp = new Lamp();
        lamp.toggle();
        boolean isLampOn = PredicateExample.doSomethingWithPredicate(lamp, predicate3);
        System.out.println(isLampOn);

    }

    private static <T> boolean doSomethingWithPredicate( T t, Predicate<T> predicate){
        return predicate.test(t);
    }

    private static <T> boolean doSomethingWith( T t, Predicate<T> predicate){

        return predicate.test(t);
    }
}
