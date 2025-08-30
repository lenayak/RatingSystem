package com.example.demo.Repositories;

import com.example.demo.Entities.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository  
public class RestaurantRepository {
    private final List<Restaurant> restaurants = new ArrayList<>();
    private long nextId = 1;

    public Restaurant save(Restaurant restaurant) {
        restaurant.setId(nextId++);
        restaurants.add(restaurant);
        return restaurant;
    }

    public boolean remove(Long id) {
        return restaurants.removeIf(r -> r.getId().equals(id));
    }

    public List<Restaurant> findAll() {
        return new ArrayList<>(restaurants);
    }

    public Optional<Restaurant> findById(Long id) {
        return restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }
}