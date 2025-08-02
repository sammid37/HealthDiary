package com.sammid37.HealthDiary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sammid37.HealthDiary.model.Sleep;
import com.sammid37.HealthDiary.service.SleepService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sleep")
public class SleepController {
    @Autowired
    private SleepService sleepService;

    public SleepController(SleepService sleepService) {
        this.sleepService = sleepService;
    }

    @PostMapping("/save")
    public ResponseEntity<Sleep> createSleep(@RequestBody @Valid Sleep sleep) {
        Sleep created = sleepService.save(sleep);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sleep> getSleepById(@PathVariable Long id) {
        return sleepService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/list")
    public ResponseEntity<List<Sleep>> getAllSleep() {
        List<Sleep> sleeps = sleepService.findAll();
        return ResponseEntity.ok(sleeps);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Sleep> updateSleep(@PathVariable Long id, @RequestBody @Valid Sleep sleep) {
        try {
            Sleep updated = sleepService.update(id, sleep);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSleep(@PathVariable Long id) {
        try {
            sleepService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
