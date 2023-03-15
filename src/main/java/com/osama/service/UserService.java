package com.osama.service;

import com.osama.exception.ResourceNotFoundException;
import com.osama.model.Users;
import com.osama.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public Users updateUser(int id, Users userDetails) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        user.setName(userDetails.getName());
        user.setDepName(userDetails.getDepName());
        // set other properties as needed

        Users updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public void deleteUser(int id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        userRepository.delete(user);
    }

    public Optional<Users> getUserById(int id) {
        return userRepository.findById(id);
    }
}
