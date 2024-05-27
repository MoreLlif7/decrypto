package com.epsi.decrypto.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epsi.decrypto.entites.User;
import com.epsi.decrypto.repositories.UserRepository;
import com.epsi.decrypto.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
