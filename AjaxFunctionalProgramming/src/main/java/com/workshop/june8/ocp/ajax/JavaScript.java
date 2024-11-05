package com.workshop.june8.ocp.ajax;

public class JavaScript {

    public static void main(String[] args) {

        JQuery $ = new JQuery();

        JavaScriptObject javaScriptObject = new JavaScriptObject(
            "/api/room",
            "get",
            "json",
            data -> {
                System.out.println("Data: " + data );
            },
            error -> {
                System.out.println("Error: " + error);
            }
        );

        $.ajax( javaScriptObject);
        $.setHttpStatus( 500);
        $.ajax( javaScriptObject);
    }
}
