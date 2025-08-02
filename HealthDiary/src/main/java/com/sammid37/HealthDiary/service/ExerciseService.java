package com.sammid37.HealthDiary.service;

import java.util.List;
import java.util.Optional;

import com.sammid37.HealthDiary.model.Exercise;

public interface ExerciseService {
    Exercise save(Exercise exercise);
    Optional<Exercise> findById(Long id);
    List<Exercise> findAll();
    Exercise update(Long id, Exercise exercise);
    void delete(Long id);
}
