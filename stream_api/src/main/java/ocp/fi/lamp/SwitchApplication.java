package ocp.fi.lamp;

import ocp.fi.predicate.Dj;

public class SwitchApplication {

    private static void doSomethingWithLamp( Lamp lamp, Switcher<Lamp> switcher){
        lamp = switcher.apply(lamp);
    }
    // Generic version
    private static <T> void doSomethingWithObjectT( T t, Switcher<T> switcher){
        t = switcher.apply(t);
    }

    public static void main(String[] args) {

        Switcher<Lamp> switcher =  (b) -> {
            b.toggle();
            return b;
        };

        Switcher<String> switcher2 =  (String b) -> {
            return b;
        };

        Switcher<Integer> switcher3 = (i) -> {
            Lamp lamp = new Lamp();
            lamp.toggle();
            return 4;
        };

        Lamp lamp = new Lamp();

        System.out.println( lamp.toString());
        SwitchApplication.doSomethingWithLamp( lamp, switcher);
       SwitchApplication.doSomethingWithObjectT( lamp, switcher);
        SwitchApplication.doSomethingWithObjectT(new Dj("", 4), (i) ->  new Dj( "", 34));
        System.out.println( lamp.toString());

    }

}
