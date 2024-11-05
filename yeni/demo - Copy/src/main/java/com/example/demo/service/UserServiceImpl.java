package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    List<User> users = Arrays.asList(new User("Caner", "sanane@gmail.com"),
            new User("Ahmet", "banane@gmail.com"), new User("Kemal", "bosver@dostum.com"));



    @Override
    public List<User> getAllUser() {
        return users;
    }

    @Override
    public Optional<User> getUserById() {
        return Optional.empty();
    }
}
