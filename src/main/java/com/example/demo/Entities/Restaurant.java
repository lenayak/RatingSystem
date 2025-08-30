package com.example.demo.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data  
@NoArgsConstructor  
public class Restaurant {
    private Long id;
    private String name;
    private String description;
    private CuisineType cuisineType;
    private BigDecimal averageBill;
    private BigDecimal rating;
    public CuisineType getTypeCuisine() {
        return cuisineType;
    }
    public BigDecimal getAveCheck() {
        return averageBill;
    }
}