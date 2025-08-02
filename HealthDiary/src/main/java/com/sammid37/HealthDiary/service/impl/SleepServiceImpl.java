package com.sammid37.HealthDiary.service.impl;

import org.springframework.stereotype.Service;

import com.sammid37.HealthDiary.model.Sleep;
import com.sammid37.HealthDiary.repository.SleepRepository;
import com.sammid37.HealthDiary.service.SleepService;

import jakarta.persistence.EntityNotFoundException;


import java.util.List;
import java.util.Optional;

@Service
public class SleepServiceImpl implements SleepService {
    private final SleepRepository sleepRepository;

    public SleepServiceImpl(SleepRepository sleepRepository) {
        this.sleepRepository = sleepRepository;
    }

    @Override
    public Sleep save(Sleep sleep) {
        return sleepRepository.save(sleep);
    }

    @Override
    public Optional<Sleep> findById(Long id) {
        return sleepRepository.findById(id);
    }

    @Override
    public List<Sleep> findAll() {
        return sleepRepository.findAll();
    }

    @Override
    public Sleep update(Long id, Sleep sleep) {
        Sleep existing = sleepRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sleep record not found with id " + id));
    
        existing.setSleepStart(sleep.getSleepStart());
        existing.setSleepEnd(sleep.getSleepEnd());
        existing.setSleepStages(sleep.getSleepStages());
        existing.setNotes(sleep.getNotes());

        return sleepRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!sleepRepository.existsById(id)) {
            throw new EntityNotFoundException("Sleep record with id " + id + " not found");
        }

        sleepRepository.deleteById(id);
    }
}
