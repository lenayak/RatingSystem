package com.example.demo.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data  
@NoArgsConstructor  
@Entity  
@Table(name = "restaurants")
public class Restaurant {
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CuisineType cuisineType;
    @Column(nullable = false)
    private BigDecimal averageBill;
    @Column(nullable = false)
    private BigDecimal rating;
    
    public CuisineType getTypeCuisine() {
        return cuisineType;
    }
    public BigDecimal getAveCheck() {
        return averageBill;
    }
    public BigDecimal getUserRating() {
        return rating;
    }
    public void setTypeCuisine(CuisineType typeCuisine) {
        this.cuisineType = typeCuisine;
    }
    public void setAveCheck(BigDecimal aveCheck) {
        this.averageBill = aveCheck;
    }
}