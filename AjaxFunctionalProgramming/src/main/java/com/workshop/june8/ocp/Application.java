package com.workshop.june8.ocp;

import java.util.function.Function;

public class Application {

    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface = ( k, l) ->  k + l;

        int result = process( myFunctionalInterface, 7, 9);
        System.out.println( result);

        result = process( ( k, l) -> k - l, 7, 9);
        System.out.println( result);

        AnotherFunctionalInterface anotherFunctionalInterface = ( k, l) ->  l.replace( k, "");
        // Create a second process method that handles this F.I.
        // and call it with a lambda that removes the first
        // string from te second and turns the result to uppercase
        //    Turn 'This is NOT a string' into  'THIS IS A STRING'

        String res = process2( anotherFunctionalInterface, "NOT ", "This is NOT a string");
        System.out.println(res);

        Function<Integer, String> function = (  s) -> "" + ( s*s);



    }

    private static String process2(AnotherFunctionalInterface anotherFunctionalInterface, String s1, String s2) {
        return anotherFunctionalInterface.sum( s1, s2);
    }

    private static int process( MyFunctionalInterface myFunctionalInterface, int i, int j){

        return myFunctionalInterface.sum( i, j);

    }

}
