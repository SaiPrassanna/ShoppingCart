package com.market.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.Entity.CartEntity;
import java.util.Optional;
import com.market.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public CartEntity updateCart(Long id,CartEntity updatedCart) {
    	Optional<CartEntity>optionalCart = cartRepository.findById(id);
    	if(optionalCart.isPresent()) {
    		CartEntity existingCart = optionalCart.get();
    		existingCart.setTotalAmount(updatedCart.getTotalAmount());
    		existingCart.setName(updatedCart.getName());
    	
        
		return cartRepository.save(existingCart);
    }
    return null;
    }
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

}
