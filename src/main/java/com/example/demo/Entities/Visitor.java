package com.example.demo.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor  
public class Visitor {
    private Long id;
    private String name; // необязательное  
    private int age;     // обязательное  
    private String gender; // обязательное  
}
