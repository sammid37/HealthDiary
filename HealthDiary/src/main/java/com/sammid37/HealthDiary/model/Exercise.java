package com.sammid37.HealthDiary.model;

import java.time.LocalDateTime;

import com.sammid37.HealthDiary.model.enums.ExerciseIntensity;
import com.sammid37.HealthDiary.model.enums.ExerciseType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "exercise_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="The exercise must have a name")
    private String exerciseName;

    @Positive(message="The exercise series number must be a positive value")
    private Integer series;

    @Positive(message="Exercise repeats must be a positive value")
    private Integer repeats;

    @NotNull(message="The exercise date and time cannot be null")
    private LocalDateTime exerciseDateTime;
   
    @Enumerated(EnumType.STRING)
    @NotNull(message="Exercise type cannot be null")
    private ExerciseType exerciseType; 

    @Positive(message="Exercise duration must be a positive value")
    private Double durationInMinutes;

    // carga do exercício
    @Positive(message="The exercise load must be a positive value")
    private Double exerciseLoad;

    @Positive(message="The number of calories burned during exercise must be positive")
    private Integer caloriesBurned;

    @Enumerated(EnumType.STRING)
    private ExerciseIntensity intensity;
    
    @Column(columnDefinition="TEXT")
    private String notes;

    @Column(updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime updatedAt;
}
