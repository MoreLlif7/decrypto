package com.epsi.decrypto.services;

import java.util.List;

import com.epsi.decrypto.entites.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();
}
