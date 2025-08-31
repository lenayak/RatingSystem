package com.example.demo.Services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.DTO.RestaurantRequestDTO;
import com.example.demo.DTO.RestaurantResponseDTO;
import com.example.demo.Entities.Restaurant;
import com.example.demo.Entities.Visitor;
import com.example.demo.Repositories.RestaurantRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;   


@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {
    @Mock
    private RestaurantRepository restauranRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    @Test
    void saveRestaurant_ShouldReturnSavedRestaurant() {
        RestaurantRequestDTO restaurant = new RestaurantRequestDTO("Pizza Place", "123 Main St", "Итальянская", 600);
        Restaurant savedRestaurant = new Restaurant();

        when(restauranRepository.save(any(Restaurant.class))).thenReturn(savedRestaurant);

        RestaurantResponseDTO result = restaurantService.saveRestaurant(restaurant);

        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals("Pizza Place", result.name());
    }

    @Test
    void getRestaurantById_ShouldReturnRestaurant() {
        Restaurant restaurant = new Restaurant();

        when(restauranRepository.findById(1L)).thenReturn(null, null);
        Visitor result = restaurantService.getRestaurantById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Pizza Place", result.getName());
    }

    @Test
    void getRestaurantById_ShouldThrowException_WhenNotFound() {
        when(restauranRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            restaurantService.getRestaurantById(1L);
        });

        assertEquals("Ресторан не найден", exception.getMessage());
    }
}
