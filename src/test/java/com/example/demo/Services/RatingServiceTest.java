package com.example.demo.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.demo.DTO.RatingRequestDTO;
import com.example.demo.DTO.RatingResponseDTO;
import com.example.demo.Entities.RatingVisitor;
import com.example.demo.Repositories.RatingVisitorRepository;
import com.example.demo.Repositories.RestaurantRepository;
import com.example.demo.Repositories.VisitorRepository;
import com.example.demo.Entities.Visitor;
import com.example.demo.Entities.Restaurant;

import java.util.List;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {
    @Mock
    private RatingVisitorRepository ratingRepository;

    @Mock
    private VisitorRepository visitorRepository;

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RatingVisitorService ratingService;

    @Test
    void addRating_ShouldReturnSavedRating() {
        RatingRequestDTO ratingRequest = new RatingRequestDTO(1L, 1L, 5, "Отличный ресторан!");

        Visitor visitor = new Visitor(1L, "John Doe", 30, "Мужской");
        Restaurant restaurant = new Restaurant();
    
        when(visitorRepository.findById(1L)).thenReturn(java.util.Optional.of(visitor));
        when(ratingRepository.findAverageRatingByRestaurantId(1L)).thenReturn(5.0);

        RatingResponseDTO result = ratingService.addRating(ratingRequest);

        assertNotNull(result);
        assertEquals(1L, result.idVisitor());
        assertEquals(1L, result.idRestaurant());
        assertEquals(5, result.rating());
        assertEquals("Отличный ресторан!", result.textReview());

        verify(visitorRepository).findById(1L);
        verify(restaurantRepository).findById(1L);
        verify(ratingRepository).save(any(RatingVisitor.class));
        verify(ratingRepository).findAverageRatingByRestaurantId(1L);
    }

    @Test
    void removeRating_ShouldCallDeleteById() {
        RatingVisitor rating = new RatingVisitor();
        rating.setId(1L);
        Restaurant restaurant = new Restaurant();
        restaurant.setId(1L);
        rating.setRestaurantId(restaurant);

        when(ratingRepository.findById(1L)).thenReturn(java.util.Optional.of(rating));
        when(ratingRepository.findAverageRatingByRestaurantId(1L)).thenReturn(4.5);

        ratingService.removeRating(1L);

        verify(ratingRepository).deleteById(1L);
        verify(ratingRepository).findAverageRatingByRestaurantId(1L);
    }

    @Test
    void getAllRatings_ShouldReturnList() {
        // Given
        when(ratingRepository.findAll()).thenReturn(List.of(
            new RatingVisitor(),
            new RatingVisitor()
        ));

        List<RatingResponseDTO> result = ratingService.getAllRatings();

        assertEquals(2, result.size());
        verify(ratingRepository).findAll();
    }
}
