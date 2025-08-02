package com.sammid37.HealthDiary.controller;

import com.sammid37.HealthDiary.model.Meal;
import com.sammid37.HealthDiary.service.MealService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    private MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/save")
    public ResponseEntity<Meal> createMeal(@RequestBody @Valid Meal meal) {
        Meal created = mealService.save(meal);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meal> getMealById(@PathVariable Long id) {
        return mealService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/list")
    public ResponseEntity<List<Meal>> getAllMeals() {
        List<Meal> meal = mealService.findAll();
        return ResponseEntity.ok(meal);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Meal> updateMeal(@PathVariable Long id, @RequestBody @Valid Meal meal) {
        try {
            Meal updated = mealService.update(id, meal);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMeal(@PathVariable Long id) {
        try {
            mealService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
