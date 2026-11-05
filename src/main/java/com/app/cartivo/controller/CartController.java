package com.app.cartivo.controller;

import com.app.cartivo.dto.CartItemRequest;
import com.app.cartivo.model.CartItem;
import com.app.cartivo.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    @PostMapping
    public ResponseEntity<String> addToCart(
            @RequestHeader("X-User-ID") String userId,
            @RequestBody CartItemRequest request){
       if (!cartService.addToCart(userId, request)){
            return ResponseEntity.badRequest().body("Product out of stock or user not found or product not found");
       }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/items/{productId}")
    public ResponseEntity<Void> removeFromCart(
            @RequestHeader("X-User-ID") String userId,
            @PathVariable Long productId){
        boolean deleted = cartService.deleteItemFromCart(userId, productId);
        return deleted? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getCart(
            @RequestHeader("X-user-ID") String userId){
        return ResponseEntity.ok(cartService.getCart(userId));
    }

}
