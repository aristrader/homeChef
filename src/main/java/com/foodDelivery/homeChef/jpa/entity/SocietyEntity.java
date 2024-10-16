package com.foodDelivery.homeChef.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "society")
@Data
public class SocietyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "society_id")
    private Integer societyId;

    @NotNull
    @Size(max = 100)
    @Column(name = "society_name", nullable = false)
    private String societyName;

    @NotNull
    @Size(max = 255)
    @Column(name = "society_address", nullable = false)
    private String societyAddress;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
