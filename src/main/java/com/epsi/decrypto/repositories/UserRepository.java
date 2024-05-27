package com.epsi.decrypto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epsi.decrypto.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


}
