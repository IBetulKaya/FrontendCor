package ocp.fi.function;

import ocp.fi.lamp.Lamp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionExample {

    Function function;

    public static void main(String[] args) {

        FunctionExample functionExample = new FunctionExample();

        Function<Integer, Integer> function = (x) -> 3 * x;

        Function<Lamp, String> function2 = (l) -> "Lamp: " + l.toString();

        // Needs to be 'effectively' final, if used in lambda
        String message = "Hallo";

        // Needs to be 'effectively' final, if used in lambda
        final Lamp finalLamp = new Lamp(true, 150);

        Function<Integer, List<Lamp>> function3 = (x) -> {
            List<Lamp> lamps = new ArrayList<>();
            // Note: Although final, state of the object can be changed!
            finalLamp.toggle();
            System.out.println(message);
            for( int i = 0; i < x; i++){
                lamps.add( new Lamp(true, 70));
            }
            return lamps;
        };

        Integer result1 = functionExample.useFunction( 5, function);
        System.out.println( result1);

        String result2 = functionExample.useFunction( new Lamp( false, 120), function2);
        System.out.println( result2);

        List<Lamp> lamps = functionExample.useFunction(34, function3);
        System.out.println( lamps);

        // We can define our own 'Function' if we require more parameters
        // Note: this custom Functional Interface CANNOT be used in any of the Stream API methods
        MyFunction<String, String, String, String, String> myFunction =
                (a, b, c, d) -> a + b + c + d;

        // We can use it in our own methods
        String result = functionExample.useFunction("Dit ","werkt ","prima","!", myFunction);
        System.out.println( result);

    }

    // Most generic form
    private <T, R> R useFunction( T t, Function<T, R> function){
        return function.apply(t);
    }

    // Less generic form, better readable
    private <T> Boolean useFunction2( T t, Function<T, Boolean> function){
        return function.apply(t);
    }

    // Specific, non-generic form
    private Boolean useFunction3( Lamp l, Function<Lamp, Boolean> function){
        return function.apply(l);
    }

    // Use our custom Functional Interface with four parameters
    private <A,B,C,D,R> R useFunction( A a, B b, C c, D d, MyFunction<A,B,C,D,R> myFunction){
        return myFunction.apply(a,b,c,d);
    }



}
