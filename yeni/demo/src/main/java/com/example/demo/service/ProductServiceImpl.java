package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements  ProductService{
    private final ProductRepository productRepository;
    @Autowired

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }







    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById() {
        return Optional.empty();
    }


    }

