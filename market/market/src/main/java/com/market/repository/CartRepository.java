package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.Entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
