package com.pris.project.prisprojectmonolith.service;

import com.pris.project.prisprojectmonolith.model.User;
import com.pris.project.prisprojectmonolith.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // Generate a unique username based on name, surname, and random number
        String generatedUsername = generateUniqueUsername(user.getName(), user.getSurname());

        // Set username and role
        user.setUsername(generatedUsername);
        user.setRole("USER");

        // Save the user
        return userRepository.save(user);
    }

    private String generateUniqueUsername(String name, String surname) {
        String baseUsername = name.toLowerCase() + surname.toLowerCase();
        Random random = new Random();
        int randomSuffix = random.nextInt(900) + 100; // Generate random 3-digit number
        String username = baseUsername + randomSuffix;

        return username;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserkById(int id) {
        return userRepository.findById(id);
    }

    public User updateUser(int id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            user.setIdUser(id);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("Artwork with id " + id + " not found");
        }
    }

    public void deleteUser(int id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User with id " + id + " not found");
        }
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> authenticateUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (password.equals(user.getPassword())) {
                // Compare plain-text password with stored plain-text password (not recommended)
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

}
