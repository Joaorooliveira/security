package dev.joaov.security.dto.request;


import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(
        @NotEmpty(message = "Nome obrigatorio")
        String name,
        @NotEmpty(message = "Email Obrigatorio")
        String email,
        @NotEmpty(message = "Senha obrigatoria")
        String password) {
}
