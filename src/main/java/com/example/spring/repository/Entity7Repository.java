package com.example.spring.repository;

import com.example.spring.entity.Entity7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity7Repository extends JpaRepository<Entity7, Integer> {
}
