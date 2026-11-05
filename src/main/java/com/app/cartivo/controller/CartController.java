package com.app.cartivo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @PostMapping
    public ResponseEntity<Void> addToCart(
            @RequestHeader("X-User-ID") String userId,
            @RequestBody CartItemRequest request){
        cartService.addToCart(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
