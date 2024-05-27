package com.epsi.decrypto.services;

import java.util.List;

import com.epsi.decrypto.entites.Partie;


public interface PartieService {
    Partie createPartie(Partie partie);

    List<Partie> getAllParties();
}
