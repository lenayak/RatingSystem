package com.example.demo.Services;

import com.example.demo.Entities.Restaurant;
import com.example.demo.Repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

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
}

