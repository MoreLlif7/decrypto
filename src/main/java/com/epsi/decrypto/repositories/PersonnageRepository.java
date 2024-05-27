package com.epsi.decrypto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epsi.decrypto.entites.Personnage;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Long> {
}
