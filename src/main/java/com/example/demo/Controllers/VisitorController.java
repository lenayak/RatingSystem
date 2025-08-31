package com.example.demo.Controllers;

import com.example.demo.DTO.VisitorRequestDTO;
import com.example.demo.DTO.VisitorResponseDTO;
import com.example.demo.Services.VisitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/visitors")
@Tag(name = "Посетители", description = "API для работы с посетителями")
public class VisitorController {
    private final VisitorService visitorService;
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }
    @GetMapping
    @Operation(summary = "Получить всех посетителей")
    public List<VisitorResponseDTO> findAll() {
        return visitorService.getAllVisitors();
    }
    @PostMapping
    @Operation(summary = "Создать нового посетителя")
    public VisitorResponseDTO createVisitor(@RequestBody VisitorRequestDTO request) {
        return visitorService.saveVisitor(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить данные посетителя")
    public VisitorResponseDTO updateVisitor(@PathVariable Long id, @RequestBody VisitorRequestDTO request) {
        visitorService.removeVisitor(id);
        return visitorService.saveVisitor(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить посетителя")
    public void deleteVisitor(@PathVariable Long id) {
        visitorService.removeVisitor(id);
    }
}