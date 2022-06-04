package com.productos.back.controller;

import com.productos.back.service.ProductService;
import com.productos.back.persistence.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
       return this.productService.createProduct(product);
    }

    @GetMapping("/all")
    public List<Product> findAll(){
        return this.productService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/get/{id}")
    public Optional<Product> obtenerProductoporId(Long id) {
        return this.productService.getProduct(id);
    }


}
