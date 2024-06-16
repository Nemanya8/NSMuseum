package com.pris.project.prisprojectmonolith.service;


import com.pris.project.prisprojectmonolith.model.User;
import com.pris.project.prisprojectmonolith.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserkById(int id){
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

	public User registerUser(User user) {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
        	throw new RuntimeException("A user with an email " + user.getEmail() + " already exists");
        }
		return userRepository.save(user);
	}

	public User loginUser(User user) {
		Optional<User> checkedUser = userRepository.findByEmail(user.getEmail());
        if (checkedUser.isPresent()) {
        	return user;
        }else
        	throw new RuntimeException("A user with an email " + user.getEmail() + " doesn't exist");
	}
}
