package com.sammid37.HealthDiary.service.impl;

import com.sammid37.HealthDiary.model.Meal;
import com.sammid37.HealthDiary.repository.MealRepository;
import com.sammid37.HealthDiary.service.MealService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal save(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public Optional<Meal> findById(Long id) {
        return mealRepository.findById(id);
    }

    @Override
    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    @Override
    public Meal update(Long id, Meal meal) {
        Meal existing = mealRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Meal record not found with id " + id));

        // TODO: verificar se está atualizando todos os atributoss
        existing.setNotes(meal.getNotes());
        existing.setCalories(meal.getCalories());

        return mealRepository.save(existing);

    }

    @Override
    public void delete(Long id) {
        if(!mealRepository.existsById(id)) {
            throw new EntityNotFoundException("Meal record with id " + id + " not found");
        }

        mealRepository.deleteById(id);
    }

}
