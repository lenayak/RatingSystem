package com.example.demo.DTO;

public record RatingRequestDTO(
    Long idVisitor,
    Long idRestaurant,
    int rating,
    String textReview
) {}
