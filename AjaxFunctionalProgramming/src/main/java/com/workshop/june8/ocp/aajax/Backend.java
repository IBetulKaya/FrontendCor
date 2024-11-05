package com.workshop.june8.ocp.aajax;

public class Backend {

    public static Response endpoint( String url) {

        if( url.contains("user")){
            Response response = new Response( 500, null, "Internal error!");
            return response;
        }
        if( url.contains("room")){
            String body = "{ \"rooms\": [\"room 1\",\"room 2\",\"room 3\"]}";
            Response response = new Response( 200, body, null);
            return response;
        }
        Response response = new Response( 404, null, "Not found!");
        return response;
    }
}
