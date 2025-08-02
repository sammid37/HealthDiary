package com.sammid37.HealthDiary.controller;

import com.sammid37.HealthDiary.model.Exercise;
import com.sammid37.HealthDiary.model.Meal;
import com.sammid37.HealthDiary.model.Sleep;
import com.sammid37.HealthDiary.repository.ExerciseRepository;
import com.sammid37.HealthDiary.repository.MealRepository;
import com.sammid37.HealthDiary.repository.SleepRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private SleepRepository sleepRepository;

    @GetMapping
    public String crud(Model model) {
        try {
            model.addAttribute("sleeps", sleepRepository.findAll());
            model.addAttribute("exercices", exerciseRepository.findAll());
            model.addAttribute("meals", mealRepository.findAll());

            model.addAttribute("exercise", new Exercise());
            model.addAttribute("meal", new Meal());
            model.addAttribute("sleep", new Sleep());

            return "crud";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "ERRO: " + e.getMessage();
        }
    }
}
