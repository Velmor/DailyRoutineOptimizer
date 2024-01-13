package com.example.DaliyOptimizer.service.impl;

import com.example.DaliyOptimizer.Exceptions.UserNotFoundException;
import com.example.DaliyOptimizer.model.Task;
import com.example.DaliyOptimizer.model.User;
import com.example.DaliyOptimizer.repository.UserRepository;
import com.example.DaliyOptimizer.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(int id) {
        return userRepository.findById((long) id);
    }

    public void deleteById(int id) {
        userRepository.deleteById((long) id);
    }

    public Optional<User> create(User userCreate)
    {
        User user = new User(userCreate.getName(), userCreate.getEmail());
        userRepository.save(user);
        return Optional.of(user);
    }

    public Optional<User> edit(int id, User userEdit) {
        Optional<User> optionalUser = userRepository.findById((long) id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userEdit.getName());
            user.setEmail(userEdit.getEmail());
            userRepository.save(user);
            return Optional.of(user);
        } else {
            // Handle the case where the user with the given ID does not exist
            throw new UserNotFoundException("User with ID " + id + " not found.");
        }
    }

    public List<Task> getTasksForUser(Long userId) {
        // Finding the user by their ID using the UserRepository
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Assuming User has a method to retrieve tasks, replace with your actual logic.
            List<Task> userTasks = user.getTasks();
            return userTasks;
        } else {
            // Handle the case where the user with the given ID does not exist
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
    }
}
