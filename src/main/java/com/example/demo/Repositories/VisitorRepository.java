package com.example.demo.Repositories;

import com.example.demo.Entities.Visitor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository  
public class VisitorRepository {
    private final List<Visitor> visitors = new ArrayList<>();
    private long nextId = 1;

    public Visitor save(Visitor visitor) {
        visitor.setId(nextId++);
        visitors.add(visitor);
        return visitor;
    }

    public boolean remove(Long id) {
        return visitors.removeIf(v -> v.getId().equals(id));
    }

    public List<Visitor> findAll() {
        return new ArrayList<>(visitors);
    }

    public Optional<Visitor> findById(Long id) {
        return visitors.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }
}