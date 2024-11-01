package com.example.springdatahw.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Person {
    @Id
    private Long id;
    private String name;
    private int age;
}