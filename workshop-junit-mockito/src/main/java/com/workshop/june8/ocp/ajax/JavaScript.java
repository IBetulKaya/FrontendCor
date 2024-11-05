package com.workshop.june8.ocp.ajax;

public class JavaScript {
    public static void main(String[] args) {
        JavaScriptObject javaScriptObject = new JavaScriptObject(
                "/api",
                "get",
                "json",
                true,
                (customers)-> {
                    System.out.println("Data: " +customers);
                },
                (error)->{
                    System.out.println("Error:" + error);
                }

        );

        JQuery $1 = new JQuery();
        $1.ajax(javaScriptObject);

        javaScriptObject = new JavaScriptObject(
                "/api",
                "get",
                "json",
                true,
                (customers)-> {
                    System.out.println("Data false: " +customers);
                },
                (error)->{
                    System.out.println("Error:" + error);
                }

        );
        JQuery $2 = new JQuery();
        $2.ajax(javaScriptObject);






       // $.setHttpStatus(500);

    }
}
