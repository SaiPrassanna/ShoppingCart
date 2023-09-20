package com.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.Entity.ProductEntity;
import com.market.Service.ProductService;
import com.market.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    
    @PostMapping
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productRepository.save(product);
    }
    @Autowired
    private ProductService productService;

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody ProductEntity updatedProduct) {
        ProductEntity updatedProductEntity = productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok(updatedProductEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

}
