package com.example.demo.Services;

import com.example.demo.Entities.Rating;
import com.example.demo.Repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    public boolean remove(Long id) {
        return ratingRepository.remove(id);
    }

    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }
}