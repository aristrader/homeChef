package com.foodDelivery.homeChef.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "chef", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"phone_number"})
})
@Data
public class ChefEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chef_id")
    private Integer chefId;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(max = 255)
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Size(max = 100)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Size(max = 100)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "phone_number", nullable = false, unique = true)
    private Long phoneNumber;

    @Size(max = 255)
    @Column(name = "specialities")
    private String specialities;

    @Column(name = "payment_upi_no")
    private Long paymentUpiNo;

    @Size(max = 100)
    @Column(name = "payment_upi_id")
    private String paymentUpiId;

    @NotNull
    @Column(name = "society_id", nullable = false)
    private Integer societyId;

    @Column(name = "is_open", nullable = false)
    private Boolean isOpen = false;

    @Column(name = "auto_close_time")
    private Time autoCloseTime;

    @NotNull
    @Column(name = "allows_pickup", nullable = false)
    private Boolean allowsPickup = true;

    @NotNull
    @Column(name = "has_delivery", nullable = false)
    private Boolean hasDelivery = false;

    @Column(name = "estimated_delivery_time_minutes")
    private Integer estimatedDeliveryTimeMinutes;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
