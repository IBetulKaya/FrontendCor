package ocp.fi.lamp;

@FunctionalInterface
public interface Switcher <T>{

    public T apply(T t);

}
