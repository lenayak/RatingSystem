package com.example.demo.Repositories;

import com.example.demo.Entities.RatingVisitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;

@Repository  
// public class RatingVisitorRepository {
    public interface RatingVisitorRepository extends JpaRepository<RatingVisitor, Long> {
    @Query("SELECT AVG(r.rating) FROM RatingVisitor r WHERE r.restaurant.id = :restaurantId")
    Double findAverageRatingByRestaurantId(@Param("restaurantId") Long restaurantId);
    List<RatingVisitor> findByRestaurantId(Long restaurantId);
    List<RatingVisitor> findByVisitorId(Long visitorId);
    void remove(Long id);
}
    // private final List<RatingVisitor> ratings = new ArrayList<>();
    // private long nextId = 1;

    // public RatingVisitor save(RatingVisitor rating) {
    //     rating.setId(nextId++);
    //     ratings.add(rating);
    //     return rating;
    // }

    // public boolean remove(Long id) {
    //     return ratings.removeIf(r -> r.getId().equals(id));
    // }

    // public List<RatingVisitor> findAll() {
    //     return new ArrayList<>(ratings);
    // }

    // public Optional<RatingVisitor> findById(Long id) {
    //     return ratings.stream()
    //             .filter(r -> r.getId().equals(id))
    //             .findFirst();
    // }
