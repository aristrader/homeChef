package com.foodDelivery.homeChef.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @NotNull
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @NotNull
    @Column(name = "chef_id", nullable = false)
    private Integer chefId;

    @NotNull
    @Column(name = "customer_address_id", nullable = false)
    private Integer customerAddressId;

    @NotNull
    @Column(name = "order_time", nullable = false)
    private LocalDateTime orderTime;

    @NotNull
    @Size(max = 30)
    @Column(name = "order_status", nullable = false)
    private String orderStatus;

    @NotNull
    @Column(name = "is_pickup", nullable = false)
    private Boolean isPickup = false;

    @NotNull
    @Column(name = "is_delivery", nullable = false)
    private Boolean isDelivery = false;

    @NotNull
    @Size(max = 30)
    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;

    @NotNull
    @Column(name = "total_amount", nullable = false)
    private Integer totalAmount;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
