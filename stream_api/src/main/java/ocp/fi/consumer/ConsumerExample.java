package ocp.fi.consumer;

import ocp.fi.lamp.Lamp;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    Consumer consumer;

    public static void main(String[] args) {

        Consumer<String> consumer = (a) ->  System.out.println(a);
        List<String> a = new ArrayList<>();
        a.forEach(System.out::println);
        a.forEach(System.out::println);


        doSomethingWithConsumer( "Hello", consumer);

        Consumer<Lamp> lampConsumer = l -> {
            System.out.println(l.toString());
            l.toggle();
            System.out.println(l.toString());
        };

        // We pass a functional interface as a parameter
        // We pass 'functionality'
        // This is 'Functional Programming'
        doSomethingWithConsumer( new Lamp(), lampConsumer);

    }

    private static <T> void doSomethingWithConsumer( T t, Consumer<T> consumer){
        consumer.accept(t);
    }
}
