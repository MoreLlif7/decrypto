package com.epsi.decrypto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epsi.decrypto.entites.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{


}
