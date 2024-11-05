package com.workshop.june8.ocp.ajax;

public record JavaScriptObject(
        String url,
        String type,
        String dataType,
        boolean async,
        AjaxFunction success,
        AjaxFunction fail)
{

}
