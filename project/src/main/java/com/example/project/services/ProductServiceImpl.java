package com.example.project.services;

import com.example.project.models.Product;
import com.example.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        Optional<Product> prod = productRepository.findById(id);

        return prod.get();
    }

    @Override
    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product productToEdit = productRepository.getOne(id);

        productToEdit.setName(updatedProduct.getName());
        productToEdit.setDescription(updatedProduct.getDescription());
        productToEdit.setPrice(updatedProduct.getPrice());

        return productRepository.save(productToEdit);
    }

    @Override
    public String deleteProduct(Long id) {
        Product product = productRepository.getOne(id);
        productRepository.delete(product);
        return "deleted";
    }
}
