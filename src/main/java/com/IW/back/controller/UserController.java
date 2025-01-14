package com.IW.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.IW.back.model.User;
import com.IW.back.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(@RequestParam(value = "type", required = false) String type) {
        if (type != null) {
            return userRepository.findByType(type);
        }
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Error: El email es obligatorio.");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Error: El email ya está en uso.");
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            return ResponseEntity.badRequest().body("Error: Contraseña debe de contener al menos 6 carácteres.");
        }

        User savedUser = userRepository.save(user);

        return ResponseEntity.ok(savedUser.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            return ResponseEntity.badRequest().body("Error: Email o Contraseña inválidos");
        }

        if (!existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.badRequest().body("Error: Email o Contraseña inválidos");
        }

        return ResponseEntity.ok(existingUser.getId());
    }


    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/email")
    public User getUserByEmail(@RequestParam(value = "email") String email) {
        return userRepository.findByEmail(email);
    }
}
