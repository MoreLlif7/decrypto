package com.epsi.decrypto.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epsi.decrypto.entites.Users;
import com.epsi.decrypto.repositories.UserRepository;
import com.epsi.decrypto.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}
