package com.example.demo.DTO;

import java.math.BigDecimal;

import com.example.demo.Entities.CuisineType;

public record RestaurantResponseDTO(
    Long id,
    String name,
    String description,
    CuisineType typeCuisine,
    int aveCheck,
    BigDecimal userRating
) {}    
