package com.sammid37.HealthDiary.model;

import java.time.LocalDateTime;

import com.sammid37.HealthDiary.model.enums.MealType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="meal_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="Meal date and time must not be null")
    private LocalDateTime mealDateTime;

    @Enumerated(EnumType.STRING)
    @NotNull(message="Meal type must not be null")
    private MealType mealType;

    @NotNull(message="Calories must not be null")
    @Min(value = 0, message="Calories must be zero or positive")
    private Integer calories;

    @Column(columnDefinition="TEXT")
    private String items;

    private String photoUrl;

    @Column(columnDefinition="TEXT")
    private String notes;

    @Column(updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime updatedAt;
}
