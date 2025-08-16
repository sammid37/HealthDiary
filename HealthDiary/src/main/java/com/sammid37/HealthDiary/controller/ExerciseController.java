package com.sammid37.HealthDiary.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

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

import com.sammid37.HealthDiary.model.Exercise;
import com.sammid37.HealthDiary.service.ExerciseService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/exercise")
@Tag(name = "Exercícios", description = "Endpoints para gerenciamento dos registros de exercícios.")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/save")
    @Operation(
            summary = "Cria um novo registro de exercício.",
            description = "Salva um novo registro de exercício."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Registro de exercício criado com sucesso.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exercise.class))
    )
    public ResponseEntity<Exercise> createExercise(@RequestBody @Valid Exercise exercise) {
        Exercise created = exerciseService.save(exercise);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Ler um registro específico de exercício.",
            description = "Busca por um registro específico de exercício dado um ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Registro de exercício encontrado.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exercise.class))
    )
    @ApiResponse(responseCode = "400", description = "Registro de exercício não encontrado.")
    public ResponseEntity<Exercise> getExerciseById(
            @Parameter(description = "ID do registro de exercício a ser encontrado.", example = "1")
            @PathVariable Long id) {
        return exerciseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    @Operation(
            summary = "Lista todos os registros de exercício cadastrados.",
            description = "Retorna a lista de todos os registros de exercício cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de registros de exercício retornado com sucesso.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exercise.class))
    )
    public ResponseEntity<List<Exercise>> getAllExercise() {
        List<Exercise> exercises = exerciseService.findAll();
        return ResponseEntity.ok(exercises);
    }

    @PutMapping("/edit/{id}")
    @Operation(
            summary = "Atualiza um registro de exercício.",
            description = "Atualiza os dados de um registro específico de exercício dado um ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Registro de exercício atualizado com sucesso.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exercise.class)))
    @ApiResponse(responseCode = "404", description = "Registro de exercício não encontrado.")
    public ResponseEntity<Exercise> updateExercise(
            @Parameter(description = "ID do registro de exercício a ser atualizado.", example = "1")
            @PathVariable Long id, @RequestBody @Valid Exercise exercise) {
        try {
            Exercise updated = exerciseService.update(id, exercise);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Deleta um registro de exercício.",
            description = "Remove o registro específico de exercício dado um ID.")
    @ApiResponse(responseCode = "204", description = "Registro de exercício deletado com sucesso.")
    @ApiResponse(responseCode = "404", description = "Registro de exercício não encontrado.")
    public ResponseEntity<Void> deleteExercise(
            @Parameter(description = "ID do registro de exercício a ser atualizado.", example = "1")
            @PathVariable Long id) {
        try {
            exerciseService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
