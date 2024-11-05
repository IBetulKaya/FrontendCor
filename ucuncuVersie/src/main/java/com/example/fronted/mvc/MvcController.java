package com.example.fronted.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MvcController {

    @GetMapping(value = { "/", "/home"})
    public String homePage(){
        System.out.println("Inside homePage");
        return "home" ;
    }
    @GetMapping(value = {"/user"})
    public String UserPage(){
        System.out.println("Inside UserPage");
        return "user" ;
    }
    @GetMapping(value = { "calculator"})
    public String calculatorPage(){
        System.out.println("Inside calculatorPage");
        return "calculator" ;
    }
}
