package com.example.demo.DTO;

public record RatingResponseDTO(
    Long id,
    Long idVisitor,
    Long idRestaurant,
    int rating,
    String textReview
) {}


