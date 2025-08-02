package com.sammid37.HealthDiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sammid37.HealthDiary.model.Sleep;

public interface SleepRepository extends JpaRepository<Sleep, Long> {
}
