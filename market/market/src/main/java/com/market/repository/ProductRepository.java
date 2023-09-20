package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}