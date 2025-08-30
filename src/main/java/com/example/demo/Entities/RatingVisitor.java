package com.example.demo.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor  
public class RatingVisitor {
    public RatingVisitor(Long idVisitor, Long idRestaurant, int rating, String textReview) {
        this.id = idVisitor;
        this.restaurantId = idRestaurant;
        this.score = rating;
        this.reviewText = textReview;
    }
    private Long id;
    private Long visitorId;
    private Long restaurantId;
    private int score;
    private String reviewText;
    public Long getIdRestaurant() {
        return restaurantId;
    }
    public Long getIdVisitor() {
       return visitorId;
    }
    public int getRating() {
       return score;
    }
    public String getTextReview() {
        return reviewText;
    }
}