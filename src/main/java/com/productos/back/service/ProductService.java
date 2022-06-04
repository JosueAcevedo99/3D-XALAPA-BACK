package com.productos.back.service;

import com.productos.back.persistence.repository.ProductRepository;
import com.productos.back.persistence.entity.Product;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product) {
        return this.repository.save(product);
    }

    public List<Product> findAll() {
        return this.repository.findAll();
    }

    public void deleteById(Long id) {
        Optional<Product> optionalTask = this.repository.findById(id);


        this.repository.deleteById(id);
    }


    public Optional<Product> getProduct(Long id) {
        return this.repository.findById(id);
    }

}
