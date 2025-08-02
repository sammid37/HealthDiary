package com.sammid37.HealthDiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sammid37.HealthDiary.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
    
}
