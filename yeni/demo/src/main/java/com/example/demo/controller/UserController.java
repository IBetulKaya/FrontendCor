package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.processing.Generated;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {

        model.addAttribute("users", userService.getAllUser());
        return "users";
        @GetMapping("/add-user")
                public String showForm(Model model){
            return "add-user";
        }

        @PostMapping("/submit")
                public String submitForm(@ModelAttribute User user , Model model){
            model.addAtribute("x", user);
            return "user-result";
        }
    }

}
