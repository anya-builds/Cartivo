package com.app.cartivo.repository;

import com.app.cartivo.dto.ProductResponse;
import com.app.cartivo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByActiveTrue();

    Optional<Object> searchProducts(String keyword);
}
