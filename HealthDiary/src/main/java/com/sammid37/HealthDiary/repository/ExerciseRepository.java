package com.sammid37.HealthDiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sammid37.HealthDiary.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    
}
