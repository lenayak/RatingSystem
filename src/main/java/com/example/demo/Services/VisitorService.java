package com.example.demo.Services;

import com.example.demo.Entities.Visitor;
import com.example.demo.Repositories.VisitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  
public class VisitorService {
    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public Visitor save(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public boolean remove(Long id) {
        return visitorRepository.remove(id);
    }

    public List<Visitor> findAll() {
        return visitorRepository.findAll();
    }
}

