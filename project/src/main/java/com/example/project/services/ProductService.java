package com.example.project.services;

import com.example.project.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getProduct(Long id);

    Product addProduct(Product product);

    Product updateProduct(Long id, Product updatedProduct);

    String deleteProduct(Long id);
}
