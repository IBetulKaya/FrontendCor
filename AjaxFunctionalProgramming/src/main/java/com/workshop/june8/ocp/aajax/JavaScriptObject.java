package com.workshop.june8.ocp.aajax;

public record JavaScriptObject(
        String url,
        String type,
        String dataType,
        boolean async,
        AjaxFunction succes,
        AjaxFunction fail) {}
