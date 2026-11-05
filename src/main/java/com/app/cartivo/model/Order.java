package com.app.cartivo.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Order {
    private Long id;
    private User user;
    private BigDecimal totalAmount;
    private OrderStatus status=OrderStatus.PENDING;
}
