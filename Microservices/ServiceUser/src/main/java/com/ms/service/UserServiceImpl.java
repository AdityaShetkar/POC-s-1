package com.ms.service;

import com.ms.entity.User;
import com.ms.exception.ResourceNotFound;
import com.ms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User getById(String userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFound("User with given Id is not found on server!!"));
    }

    @Override
    public User save(User user) {
        User user1 = this.userRepository.save(user);
        return user1;
    }

    @Override
    public void delete(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFound("User with given Id is not found on server!!"));
        this.userRepository.deleteById(userId);
    }

    @Override
    public User update(User user, String userId) {
        User user1 = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFound("User with given Id is not found on server!!"));

        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout());

        User updatedUser = this.userRepository.save(user1);
        return updatedUser;
    }
}
