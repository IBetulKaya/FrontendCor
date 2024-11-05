package com.workshop.june8.ocp.ajax;

public class JQuery {

    int httpStatus = 200;

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void ajax(JavaScriptObject javaScriptObject) {
        // We call the backend
        // when http status is 200, execute 'succes' with json: { "message": "Hello World!"}
        // else, execute 'fail'

        if( httpStatus == 200){
            AjaxFunction myFunction = javaScriptObject.succes();
            String message = "{ \"message\": \"Hello World!\"}";
            myFunction.apply( message);
        }else{
            AjaxFunction myFunction = javaScriptObject.fail();
            String message = "{ \"error\": \"Internal server error!\"}";
            myFunction.apply( message);
        }
    }
}
