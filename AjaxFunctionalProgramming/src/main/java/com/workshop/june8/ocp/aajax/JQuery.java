package com.workshop.june8.ocp.aajax;

public class JQuery {

    public void ajax( JavaScriptObject javaScriptObject){

        // Depending on async, backend is called in seperate thread
        // Based on the http status the succes or fail method is called

        if( javaScriptObject.async()){

            Runnable runnable;
            runnable = ()->{

                Response response = Backend.endpoint( javaScriptObject.url());

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if( response.httpStatus() == 200){
                    javaScriptObject.succes().apply(response.body());
                }else{
                    javaScriptObject.fail().apply(response.error());
                }
            };

            Thread thread = new Thread( runnable);
            thread.start();
        }else{

            Response response = Backend.endpoint( javaScriptObject.url());

            if( response.httpStatus() == 200){
                javaScriptObject.succes().apply(response.body());
            }else{
                javaScriptObject.fail().apply(response.error());
            }
        }
    }
}
