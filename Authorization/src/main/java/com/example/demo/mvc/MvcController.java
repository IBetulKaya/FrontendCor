package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    // http://localhost:9090/
    // http://localhost:9090/home
    @GetMapping({"/", "/home"})
    public String homePage() {

        System.out.println("Inside homePage");

        return "home";
    }

    // http://localhost:9090
    @GetMapping("/login")
    public String loginPage() {

        System.out.println("Inside loginPage");

        return "login";
    }

    // http://localhost:9090/customer
    @GetMapping("/customer")
    public String customerPage() {

        System.out.println("Inside customerPage");

        // use customer for normal use
        return "customer";
    }

    // http://localhost:9090/reservation
    @GetMapping("/reservation")
    public String reservationPage() {

        System.out.println("Inside reservationPage");

        return "reservation";
    }

    // http://localhost:9090/contact
    @GetMapping("/contact")
    public String contactPage() {

        System.out.println("Inside contactPage");

        return "contact";
    }

    // http://localhost:9090/blog
    @GetMapping("/blog")
    public String blogPage() {

        System.out.println("Inside blogPage");

        return "blog";
    }

    // http://localhost:9090/room
    @GetMapping("/room")
    public String roomPage() {

        System.out.println("Inside roomPage");

        return "room";
    }
}

