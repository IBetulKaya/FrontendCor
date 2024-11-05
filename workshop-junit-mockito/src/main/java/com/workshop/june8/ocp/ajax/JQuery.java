package com.workshop.june8.ocp.ajax;

public class JQuery {


    private int httpStatus = 200;

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void ajax(JavaScriptObject javaScriptObject) {
        if (javaScriptObject.async()) {
            Runnable runnable;
            runnable = () -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (httpStatus == 200) {
                    javaScriptObject.success().apply("{ \"Data\": \"Hello World!\"}");
                } else {
                    javaScriptObject.fail().apply("{ \"Error\": \"Internal server error\"}");
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
        } else {
            if (httpStatus == 200) {
                javaScriptObject.success().apply("{ \"Data\": \"Hello World!\"}");
            } else {
                javaScriptObject.fail().apply("{ \"Error\": \"Internal server error\"}");
            }

        }
    }
}