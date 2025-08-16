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

import com.sammid37.HealthDiary.model.Sleep;
import com.sammid37.HealthDiary.service.SleepService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sleep")
@Tag(name = "Sono", description = "Endpoints para gerenciamento dos registros de sono.")
public class SleepController {
    @Autowired
    private SleepService sleepService;

    public SleepController(SleepService sleepService) {
        this.sleepService = sleepService;
    }

    @PostMapping("/save")
    @Operation(
            summary = "Cria um novo registro de sono.",
            description = "Salva um novo registro de sono."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Registro de sono criado com sucesso.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Sleep.class))
    )
    public ResponseEntity<Sleep> createSleep(@RequestBody @Valid Sleep sleep) {
        Sleep created = sleepService.save(sleep);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Ler um registro específico de sono.",
            description = "Busca por um registro específico de sono dado um ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Registro de sono encontrado.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Sleep.class))
    )
    @ApiResponse(responseCode = "400", description = "Registro de sono não encontrado.")
    public ResponseEntity<Sleep> getSleepById(
            @Parameter(description = "ID do registro de sono a ser encontrado.", example = "1")
            @PathVariable Long id) {
        return sleepService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    @Operation(
            summary = "Lista todos os registros de sono cadastrados.",
            description = "Retorna a lista de todos os registros de sono cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de registros de sono retornado com sucesso.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Sleep.class))
    )
    public ResponseEntity<List<Sleep>> getAllSleep() {
        List<Sleep> sleeps = sleepService.findAll();
        return ResponseEntity.ok(sleeps);
    }

    @PutMapping("/edit/{id}")
    @Operation(
            summary = "Atualiza um registro de sono.",
            description = "Atualiza os dados de um registro específico de sono dado um ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Registro de sono atualizado com sucesso.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Sleep.class)))
    @ApiResponse(responseCode = "404", description = "Registro de sono não encontrado.")
    public ResponseEntity<Sleep> updateSleep(
            @Parameter(description = "ID do registro de sono a ser atualizado.", example = "1")
            @PathVariable Long id,
            @RequestBody @Valid Sleep sleep) {
        try {
            Sleep updated = sleepService.update(id, sleep);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Deleta um registro de sono.",
            description = "Remove o registro específico de sono dado um ID.")
    @ApiResponse(responseCode = "204", description = "Registro de sono deletado com sucesso.")
    @ApiResponse(responseCode = "404", description = "Registro de sono não encontrado.")
    public ResponseEntity<Void> deleteSleep(
            @Parameter(description = "ID do registro de sono a ser removido.", example = "1")
            @PathVariable Long id) {
        try {
            sleepService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
