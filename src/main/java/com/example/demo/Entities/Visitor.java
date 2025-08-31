package com.example.demo.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
// import java.util.List;

@Data  
@NoArgsConstructor  
@Entity  
@Table(name = "visitors")
public class Visitor {
    public Visitor(Long id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // необязательное  
    @Column(nullable = false)
    private int age;     // обязательное  
    @Column(nullable = false)
    private String gender; // обязательное 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor_id", nullable = false)
    Visitor visitor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    Restaurant restaurant; 
}
