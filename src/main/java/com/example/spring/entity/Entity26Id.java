package com.example.spring.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Entity26Id {
    private int age;
    private String work;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entity26Id that = (Entity26Id) o;
        return age == that.age && Objects.equals(work, that.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, work);
    }
}
