package com.foodDelivery.homeChef.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SocietyRequest {

    @NotNull(message = "Society name cannot be null")
    @Size(max = 100, message = "Society name cannot be more than 100 characters")
    private String societyName;

    @NotNull(message = "Address cannot be null")
    @Size(max = 255, message = "Address cannot be more than 255 characters")
    private String address;
}

