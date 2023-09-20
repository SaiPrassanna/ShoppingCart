package com.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.Entity.CartEntity;
import com.market.Service.CartService;
import com.market.repository.CartRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {
    
    // Inject your CartRepository here
    private final CartRepository cartRepository;

    @Autowired
    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartEntity> getCartById(@PathVariable Long id) {
        java.util.Optional<CartEntity> cart = cartRepository.findById(id);
        return cart.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
  
   
        @PostMapping
        public ResponseEntity<CartEntity> addToCart(@RequestBody CartEntity cart) {
            // Process the cart and add it to the database or perform other operations
            // For simplicity, let's assume you're just saving the cart to the database
            CartEntity savedCart = cartRepository.save(cart);
            return ResponseEntity.ok(savedCart);
        }
        @Autowired
        private CartService cartService;
        @PutMapping("/{id}")
        public ResponseEntity<CartEntity> updateCart(@PathVariable Long id, @RequestBody CartEntity updatedCart) {
            // Fetch the existing cart
   

            
            	CartEntity updated = cartService.updateCart(id, updatedCart);
            	if(updated!=null)
            	{

                return ResponseEntity.ok(updated);
            } 
        else 
        {
                return ResponseEntity.notFound().build();
            }
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
            cartService.deleteCart(id);
            return ResponseEntity.noContent().build();
        }
    }
    
    

