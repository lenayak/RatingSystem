package com.example.demo.Services;

import com.example.demo.DTO.RatingRequestDTO;
import com.example.demo.DTO.RatingResponseDTO;
import com.example.demo.Entities.RatingVisitor;
import com.example.demo.Entities.Restaurant;
// import com.example.demo.Entities.Visitor;
import com.example.demo.Repositories.RatingVisitorRepository;
import com.example.demo.Repositories.RestaurantRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service  
public class RatingVisitorService {
    private final RatingVisitorRepository ratingVisitorRepository;
    private final RestaurantRepository restaurantRepository;
    public RatingVisitorService(RatingVisitorRepository ratingVisitorRepository, RestaurantRepository restaurantRepository) {
        this.ratingVisitorRepository = ratingVisitorRepository;
        this.restaurantRepository = restaurantRepository;
    }
    public RatingResponseDTO addRating(RatingRequestDTO ratingRequestDTO) {
        RatingVisitor rating = new RatingVisitor();
        rating = ratingVisitorRepository.save(rating);
        updateRestaurantRating(ratingRequestDTO.idRestaurant());
        return convertToResponse(rating);
    }
    private RatingResponseDTO convertToResponse(RatingVisitor rating) {
        return new RatingResponseDTO(
            rating.getId(),
            rating.getIdVisitor(),
            rating.getIdRestaurant(),
            rating.getRating(),
            rating.getTextReview()
        );
    }
    private void updateRestaurantRating(Long restaurantId) {
        List<RatingVisitor> restaurantRatings = ratingVisitorRepository.findAll().stream()
                .filter(r -> r.getIdRestaurant().equals(restaurantId))
                .toList();
        if (!restaurantRatings.isEmpty()) {
            double average = restaurantRatings.stream()
                    .mapToInt(RatingVisitor::getRating)
                    .average()
                    .orElse(0.0);
            BigDecimal averageRating = BigDecimal.valueOf(average)
                    .setScale(2, RoundingMode.HALF_UP);
            Object restaurant = restaurantRepository.findById(restaurantId)
                    .orElseThrow(() -> new RuntimeException("Ресторан не найден"));
            ((Restaurant) restaurant).setRating(averageRating);
        }
    }
     public List<RatingResponseDTO> getAllRatings() {
        return ratingVisitorRepository.findAll().stream()
            .map(this::convertToResponse).toList();
    }
    public void removeRating(Long id) {
        RatingVisitor rating = ratingVisitorRepository.findAll().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Оценка не найдена"));
        ratingVisitorRepository.remove(id);
        updateRestaurantRating(rating.getIdRestaurant());
    }
}