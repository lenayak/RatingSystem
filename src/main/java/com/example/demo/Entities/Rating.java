package com.example.demo.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor  
public class Rating {
    private Long id;
    private Long visitorId;
    private Long restaurantId;
    private int score;
    private String reviewText;
}