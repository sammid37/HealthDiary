package com.sammid37.HealthDiary.service;

import java.util.List;
import java.util.Optional;

import com.sammid37.HealthDiary.model.Meal;

public interface MealService {
    Meal save(Meal meal);
    Optional<Meal> findById(Long id);
    List<Meal> findAll();
    Meal update(Long id, Meal meal);
    void delete(Long id);

}
