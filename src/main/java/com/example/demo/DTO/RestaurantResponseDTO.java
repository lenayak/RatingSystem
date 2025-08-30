package com.example.demo.DTO;

import java.math.BigDecimal;

public record RestaurantResponseDTO(
    Long id,
    String name,
    String description,
    String typeCuisine,
    int aveCheck,
    BigDecimal userRating
) {}
