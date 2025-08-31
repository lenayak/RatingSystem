package com.example.demo.Services;

import com.example.demo.DTO.VisitorRequestDTO;
import com.example.demo.DTO.VisitorResponseDTO;
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

   public VisitorResponseDTO saveVisitor(VisitorRequestDTO visitorRequestDTO) {
        Visitor visitor = new Visitor(null, visitorRequestDTO.name(), visitorRequestDTO.age(), visitorRequestDTO.gender());
        visitor = visitorRepository.save(visitor);
        return convertToResponse(visitor);
   }

    public boolean removeVisitor(Long id) {
        return visitorRepository.remove(id);
    }

    public List<Visitor> findAll() {
        return visitorRepository.findAll();
    }

     public List<VisitorResponseDTO> getAllVisitors() {
        return visitorRepository.findAll().stream()
            .map(this::convertToResponse)
            .toList();
    }

    private VisitorResponseDTO convertToResponse(Visitor visitor) {
        return new VisitorResponseDTO(visitor.getId(), visitor.getName(), visitor.getAge(), visitor.getGender());
    }
}

