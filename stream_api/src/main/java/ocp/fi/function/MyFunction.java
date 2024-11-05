package ocp.fi.function;

@FunctionalInterface
public interface MyFunction <A,B,C,D,R> {
    R apply(A a, B b, C c, D d);
}
