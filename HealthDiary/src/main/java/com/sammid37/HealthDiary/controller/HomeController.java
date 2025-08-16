package com.sammid37.HealthDiary.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Tag(name = "Index", description = "Rotas para páginas de landing page, login e afins.")
public class HomeController {

    @GetMapping
    @Operation(
            summary = "Renderiza a landing page.",
            description = "Renderiza a landing page do Healthy Diary."
    )
    public String Index() {
        return "Hello World";
    }
}
