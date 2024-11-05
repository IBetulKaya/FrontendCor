package com.workshop.june8.ocp.ajax;

@FunctionalInterface
interface AjaxFunction<T> {
    void apply(T t);
}
