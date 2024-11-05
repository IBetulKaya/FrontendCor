package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> getAllUser();
    Optional<User> getUserById();

}
