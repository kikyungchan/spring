package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "my_table4")
@Getter
@Setter
@ToString
public class Entity4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // int
    private String name; // varchar
    private Double score; // decimal(10,2)
    private LocalDate birthDate; // DATE
    private LocalTime startAt; // TIME
    private LocalDateTime createdAt; // DATETIME
}
