package com.workshop.june8.ocp.aajax;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Javascript {

    // https://www.w3schools.com/whatis/whatis_htmldom.asp
    // Document Object Model
    private static Map<String, String> dom = new HashMap<>();

    static{
        dom.put("rooms",
                "<ul>\n" +
                "  <li>Room 1</li>\n" +
                "  <li>Room 2</li>\n" +
                "</ul>");
    }

    public static void main(String[] args) {

        System.out.println( dom.get("rooms"));
        JQuery $ = new JQuery();

//        AjaxFunction ajaxFunction = new AjaxFunction() {
//            @Override
//            public void apply(String json) {
//                updateDom( "rooms", json);
//            }
//        };
//        ajaxFunction.apply("{ \"rooms\": [\"room 1\",\"room 2\",\"room 3\"]}");

        JavaScriptObject javaScriptObject = new JavaScriptObject(
            "/api/room",
            "get",
            "json",
            true,
            (rooms)-> {
                System.out.println("Data true: " + rooms);
                updateDom( "rooms", rooms);
            },
            (error)-> {
                System.out.println("Error: " + error );
            }
        );

        $.ajax( javaScriptObject);

        // /api/user will trigger 500
        javaScriptObject = new JavaScriptObject(
            "/api/user",
            "get",
            "json",
            false,
            (users)-> {    // Call back function
                System.out.println("Data : " + users);
                updateDom( "users", users);
            },
            (error)-> {    // Call back function
                System.out.println("Error: " + error );
            }
        );

        $.ajax( javaScriptObject);
    }

    private static void updateDom(String id, String json) {

        JSONObject mainObj= new JSONObject(json);
        JSONArray jsonArray = (JSONArray) mainObj.get("rooms");

        String html = "";
        for( Object object: jsonArray){
            String item = (String)object;
            html = html + "  <li>" + item + "</li>\n";
        }

        html = "<ul>\n" + html + "</ul>\n";
        dom.put( id, html);
        System.out.println( dom.get("rooms"));
    }
}
