package com.example.demo.Repositories;

import com.example.demo.Entities.Rating;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository  
public class RatingRepository {
    private final List<Rating> ratings = new ArrayList<>();
    private long nextId = 1;

    public Rating save(Rating rating) {
        rating.setId(nextId++);
        ratings.add(rating);
        return rating;
    }

    public boolean remove(Long id) {
        return ratings.removeIf(r -> r.getId().equals(id));
    }

    public List<Rating> findAll() {
        return new ArrayList<>(ratings);
    }

    public Optional<Rating> findById(Long id) {
        return ratings.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }
}

