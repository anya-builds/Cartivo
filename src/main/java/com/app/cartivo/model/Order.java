package com.app.cartivo.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Order {
    private Long id;
    private User user;
    private BigDecimal totalAmount;
    private OrderStatus status=OrderStatus.PENDING;
    private List<OrderItem> items = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
