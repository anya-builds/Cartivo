package com.app.cartivo.repository;

import com.app.cartivo.model.CartItem;
import com.app.cartivo.model.Product;
import com.app.cartivo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByUserAndProduct(User user, Product product);

    void deleteByUserAndProduct(User user, Product product);
}
