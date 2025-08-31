package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@Entity  
@Table(name = "ratings")  
public class RatingVisitor {
    // public RatingVisitor(Long idVisitor, Long idRestaurant, int rating, String textReview) {
    //     this.id = idVisitor;
    //     this.restaurantId = idRestaurant;
    //     this.score = rating;
    //     this.reviewText = textReview;
    // }
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long visitorId;
    private Long restaurantId;
    @Column(nullable = false)
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