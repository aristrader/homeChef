package com.foodDelivery.homeChef.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@Data
public class ItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    @NotNull
    @Column(name = "chef_id", nullable = false)
    private Integer chefId;

    @NotNull
    @Size(max = 100)
    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Size(max = 255)
    @Column(name = "item_description")
    private String itemDescription;

    @NotNull
    @Column(name = "item_price", nullable = false)
    private Integer itemPrice;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "auto_close_order_limit")
    private Integer autoCloseOrderLimit;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
