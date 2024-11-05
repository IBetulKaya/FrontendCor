package com.workshop.june8.ocp;

import java.util.function.Function;

public class Application {
    public static void main(String[] args){
        MyFunctionalInterface myFunctionalInterface = (k,l )->k+l;

        int result = process(myFunctionalInterface, 7 , 9);
        System.out.println(result);

        result = process((k,l)-> k-l, 7,9);
        System.out.println(result);

        AnotherFunctionalInterface anotherFunctionalInterface = (s1, s2) -> s1.replace(s2, "").toUpperCase();
        String result2 = process2(anotherFunctionalInterface, "This is NOT a string", "NOT");
        System.out.println(result2);
        //Create a second process method that handles this F.I.
        //and call it with a lambda that removes the first
        //string from te second and turns the result to uppercase
        //Turn "This is Not a string " into "THIS IS A STRING"


        Function<Integer, String> function= (s) ->"" + (s*s);
    }


    private static int process(MyFunctionalInterface myFunctionalInterface, int i, int j){

        return myFunctionalInterface.sum(i,j);
    }

    private static String process2(AnotherFunctionalInterface myFunctionalInterface, String sentence1, String sentence2){
        return myFunctionalInterface.sum(sentence1,sentence2);






    }
}
