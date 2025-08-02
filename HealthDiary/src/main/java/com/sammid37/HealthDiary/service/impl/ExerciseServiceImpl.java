package com.sammid37.HealthDiary.service.impl;

import com.sammid37.HealthDiary.model.Exercise;
import com.sammid37.HealthDiary.repository.ExerciseRepository;
import com.sammid37.HealthDiary.service.ExerciseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }


    @Override
    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public Optional<Exercise> findById(Long id) {
        return exerciseRepository.findById(id);
    }

    @Override
    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise update(Long id, Exercise exercise) {
        Exercise existing = exerciseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Exercise record not found with id" + id));

        // TODO: verificar se todas as propriedades estão sendo atualizadas
        existing.setUpdatedAt(exercise.getUpdatedAt());
        existing.setNotes(exercise.getNotes());
        existing.setExerciseType(exercise.getExerciseType());
        existing.setCaloriesBurned(exercise.getCaloriesBurned());
        existing.setExerciseDateTime(exercise.getExerciseDateTime());
        existing.setIntensity(exercise.getIntensity());

        return exerciseRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if(!exerciseRepository.existsById(id)) {
            throw new EntityNotFoundException("Exercise record with id " + id + "not found");
        }

        exerciseRepository.deleteById(id);
    }
}
