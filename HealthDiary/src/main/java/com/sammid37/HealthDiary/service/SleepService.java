package com.sammid37.HealthDiary.service;

import java.util.List;
import java.util.Optional;

import com.sammid37.HealthDiary.model.Sleep;

public interface SleepService {
    Sleep save(Sleep sleep);
    Optional<Sleep> findById(Long id);
    List<Sleep> findAll();
    Sleep update(Long id, Sleep sleep);
    void delete(Long id);
}
