package com.pedrorok.baozi.api.service;

import com.pedrorok.baozi.api.model.Product;
import com.pedrorok.baozi.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }
}

