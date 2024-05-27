package com.epsi.decrypto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epsi.decrypto.entites.Partie;

@Repository
public interface PartieRepository extends JpaRepository<Partie, Long> {
}
