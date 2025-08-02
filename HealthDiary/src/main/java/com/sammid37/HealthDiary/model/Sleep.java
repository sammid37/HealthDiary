package com.sammid37.HealthDiary.model;

import java.time.LocalDateTime;

import com.sammid37.HealthDiary.model.enums.SleepQuality;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sleep_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sleep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message= "Sleep start time cannot be null")
    private LocalDateTime sleepStart;
    
    @NotNull(message= "Sleep end time cannot be null")
    private LocalDateTime sleepEnd;

    private Double durationInHours;

    @Column(columnDefinition="TEXT")
    private String sleepStages;

    @Enumerated(EnumType.STRING)
    private SleepQuality sleepQuality;

    @Column(columnDefinition="TEXT")
    private String notes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void calcSleepDuration() {
        if(sleepStart != null && sleepEnd != null) {
            this.durationInHours = (double) java.time.Duration.between(sleepStart, sleepEnd).toMinutes() / 60;
        }
    }
}
