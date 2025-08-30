package com.example.demo.DTO;

public record RestaurantRequestDTO(
    String name,
    String description,
    String typeCuisine,
    int aveCheck
) {}
