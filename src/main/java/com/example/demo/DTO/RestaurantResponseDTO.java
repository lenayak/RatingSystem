package com.example.demo.DTO;

import java.math.BigDecimal;

import com.example.demo.Entities.CuisineType;
// import java.math.BigDecimal;

public record RestaurantResponseDTO(
    Long id,
    String name,
    String description,
    CuisineType cuisineType,
    BigDecimal averageBill,
    BigDecimal rating  
) {}
