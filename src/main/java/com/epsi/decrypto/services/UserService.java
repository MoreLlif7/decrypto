package com.epsi.decrypto.services;

import java.util.List;

import com.epsi.decrypto.entites.Users;

public interface UserService {

    Users createUser(Users user);

    List<Users> getAllUsers();
}
