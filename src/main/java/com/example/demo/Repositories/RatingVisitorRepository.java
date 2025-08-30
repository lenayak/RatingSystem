package com.example.demo.Repositories;

import com.example.demo.Entities.RatingVisitor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository  
public class RatingVisitorRepository {
    private final List<RatingVisitor> ratings = new ArrayList<>();
    private long nextId = 1;

    public RatingVisitor save(RatingVisitor rating) {
        rating.setId(nextId++);
        ratings.add(rating);
        return rating;
    }

    public boolean remove(Long id) {
        return ratings.removeIf(r -> r.getId().equals(id));
    }

    public List<RatingVisitor> findAll() {
        return new ArrayList<>(ratings);
    }

    public Optional<RatingVisitor> findById(Long id) {
        return ratings.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }
}

