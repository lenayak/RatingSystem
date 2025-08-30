package com.example.demo.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor  
public class Visitor {
    public Visitor(Long id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    private Long id;
    private String name; // необязательное  
    private int age;     // обязательное  
    private String gender; // обязательное  
}
