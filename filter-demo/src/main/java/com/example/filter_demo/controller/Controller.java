package com.example.filter_demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    //http://localhost:8080/api/filtergetparams/param
    @GetMapping(value = "filtergetparams")
    public String filter(@RequestParam String param){

        return "filtergetparams has run";
    }

    //http://localhost:8080/api/filtergetparams/param
    @PostMapping(value = "filterpostparams", consumes = "application/json")
    public String filterPostParams(@RequestBody Message param){

        return "filterpostparams has run";
    }
}
