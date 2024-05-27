package com.epsi.decrypto.controllers;

import org.springframework.web.bind.annotation.*;

import com.epsi.decrypto.entites.Partie;
import com.epsi.decrypto.services.PartieService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/public/parties")
@RequiredArgsConstructor
public class PartieController {
   
    private final PartieService partieService;

    @PostMapping
    public Partie createPartie(@RequestBody Partie partie) {
        return partieService.createPartie(partie);
    }

    @GetMapping
    public List<Partie> getAllParties() {
        return partieService.getAllParties();
    }

   
}
