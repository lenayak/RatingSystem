package com.example.demo.Controllers;

import com.example.demo.DTO.RatingRequestDTO;
import com.example.demo.DTO.RatingResponseDTO;
import com.example.demo.Services.RatingVisitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/ratings")
@Tag(name = "Оценки", description = "API для работы с оценками")
public class RatingController {
    private final RatingVisitorService ratingVisitorService;
    public RatingController(RatingVisitorService ratingVisitorService) {
        this.ratingVisitorService = ratingVisitorService;
    }
    @PostMapping
    @Operation(summary = "Добавить оценку ресторану")
      public RatingResponseDTO addRating(@RequestBody RatingRequestDTO request) {
        return ratingVisitorService.addRating(request);
    }
    @PostMapping
    @Operation(summary = "Добавить новую оценку")
    public RatingResponseDTO createRating(@RequestBody RatingRequestDTO request) {
        return ratingVisitorService.addRating(request);
    }
    @GetMapping
    @Operation(summary = "Получить все оценки")
    public List<RatingResponseDTO> getAllRatings() {
        return ratingVisitorService.getAllRatings();
    }
    @PutMapping("/{id}")
    @Operation(summary = "Обновить оценку")
    public RatingResponseDTO updateRating(@PathVariable Long id, @RequestBody RatingRequestDTO request) {
        ratingVisitorService.removeRating(id);
        return ratingVisitorService.addRating(request);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить оценку")
    public void deleteRating(@PathVariable Long id) {
        ratingVisitorService.removeRating(id);
    }
}