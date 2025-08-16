package com.sammid37.HealthDiary.controller;

import com.sammid37.HealthDiary.model.Meal;
import com.sammid37.HealthDiary.service.MealService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
@Tag(name = "Refeição", description = "Endpoints para o gerenciamento dos registros de refeição")
public class MealController {
    @Autowired
    private MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/save")
    @Operation(
            summary = "Cria um novo registro de refeição.",
            description = "Salva um novo registro de refeição."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Registro de sono criado com sucesso.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Meal.class)
            )
    )
    public ResponseEntity<Meal> createMeal(@RequestBody @Valid Meal meal) {
        Meal created = mealService.save(meal);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Ler um registro específico de refeição",
            description = "Busca por um registro específico de refeição dado um ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Registro de refeição encontrado.",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Meal.class)
            )
    )
    @ApiResponse(responseCode = "404", description = "Registro de refeição não encontrado.")
    public ResponseEntity<Meal> getMealById(
            @Parameter(description = "ID do registro de refeição a ser encontrado.")
            @PathVariable Long id) {
        return mealService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    @Operation(
            summary = "Lista todos os registros de refeição cadastrados.",
            description = "Retorna a lista de todos os registros de refeição cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de registros de refeição retornado com sucesso.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Meal.class)
            )
    )
    public ResponseEntity<List<Meal>> getAllMeals() {
        List<Meal> meal = mealService.findAll();
        return ResponseEntity.ok(meal);
    }

    @PutMapping("/edit/{id}")
    @Operation(
            summary = "Atualiza um registro de refeição.",
            description = "Atualiza os dados de um registro específico de refeição dado um ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Registro de refeição atualizado com sucesso.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Meal.class)
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Registro de refeição não encontrado.")
    public ResponseEntity<Meal> updateMeal(
            @Parameter(description = "ID do registro de refeição a ser atualizado.", example = "1")
            @PathVariable Long id, @RequestBody @Valid Meal meal) {
        try {
            Meal updated = mealService.update(id, meal);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Deleta um registro de refeição.",
            description = "Remove o registro específico de refeição dado um ID."
    )
    @ApiResponse(responseCode = "204", description = "Registro de refeição deletado com sucesso.")
    @ApiResponse(responseCode = "404", description = "Registro de refeição não encontrado.")
    public ResponseEntity<Void> deleteMeal(
            @Parameter(description = "ID do registro de refeição a ser removido.", example = "1")
            @PathVariable Long id) {
        try {
            mealService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
