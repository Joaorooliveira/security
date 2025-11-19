package dev.joaov.security.controller;

import dev.joaov.security.controller.entity.User;
import dev.joaov.security.dto.request.LoginRequest;
import dev.joaov.security.dto.request.RegisterUserRequest;
import dev.joaov.security.dto.response.LoginResponse;
import dev.joaov.security.dto.response.RegisterUserResponse;
import dev.joaov.security.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return null;

    }

    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request) {
        var newUser = new User();
        newUser.setPassword(request.password());
        newUser.setEmail(request.email());
        newUser.setName(request.name());

        userRepository.saveAndFlush(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterUserResponse(newUser.getName(), newUser.getEmail()));
    }
}
