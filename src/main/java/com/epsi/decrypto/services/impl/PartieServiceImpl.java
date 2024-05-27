package com.epsi.decrypto.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epsi.decrypto.entites.Partie;
import com.epsi.decrypto.repositories.PartieRepository;
import com.epsi.decrypto.services.PartieService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartieServiceImpl implements PartieService{

    public final PartieRepository partieRepository;

    public Partie createPartie(Partie partie) {
        return partieRepository.save(partie);
    }

    public List<Partie> getAllParties() {
        return partieRepository.findAll();
    }
    
}
