package com.market.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.Entity.ProductEntity;
import com.market.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity updateProduct(Long id, ProductEntity updatedProduct) {
        // Retrieve the existing product
        ProductEntity existingProduct = productRepository.findById(id)
                .orElseThrow();

        // Update the product properties
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());

        // Save the updated product
        return productRepository.save(existingProduct);
    }
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}