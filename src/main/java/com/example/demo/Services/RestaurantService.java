package com.example.demo.Services;

import com.example.demo.DTO.RestaurantRequestDTO;
import com.example.demo.DTO.RestaurantResponseDTO;
import com.example.demo.Entities.Restaurant;
import com.example.demo.Repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

// import java.math.BigDecimal;
import java.util.List;

@Service  
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public boolean remove(Long id) {
        return restaurantRepository.remove(id);
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public List<RestaurantResponseDTO> getAllRestaurants() {
        return  restaurantRepository.findAll().stream()
            .map(this::convertToResponse)
            .toList();
    }

    public RestaurantResponseDTO getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ресторан не найден"));
        return convertToResponse(restaurant);
    }

    public RestaurantResponseDTO saveRestaurant(RestaurantRequestDTO restaurantRequestDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant = restaurantRepository.save(restaurant);
        return convertToResponse(restaurant);
    }

    private RestaurantResponseDTO convertToResponse(Restaurant restaurant) {
        return new RestaurantResponseDTO(restaurant.getId(), restaurant.getName(), 
            restaurant.getDescription(), restaurant.getTypeCuisine(),
            restaurant.getAveCheck(), restaurant.getUserRating());
    }

    public void removeRestaurant(Long id) {
        restaurantRepository.remove(id);
    }
}

