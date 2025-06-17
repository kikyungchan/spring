package com.example.spring.repository;

import com.example.spring.entity.Entity17;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface Entity17Repository extends JpaRepository<Entity17, Integer> {
    @Query(value = """
            SELECT * 
            FROM employee
             WHERE birth_date 
             BETWEEN :start AND :end;

""", nativeQuery = true)
    List<Entity17> query1(LocalDate start, LocalDate end);

    @Query(value = """
SELECT *
FROM employee
WHERE last_name LIKE :keyword
OR first_name LIKE :keyword
""", nativeQuery = true)
    List<Entity17> query2(String keyword);

    @Query(value = """
SELECT a
FROM Entity17 a
WHERE a.firstName LIKE :keyword
OR a.lastName LIKE :keyword
""")
    List<Entity17> query3(@Param("keyword") String keyword);

    List<Entity17> findByBirthDateBetween(LocalDate start, LocalDate end);
}