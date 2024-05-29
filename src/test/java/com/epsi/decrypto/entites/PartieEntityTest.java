package com.epsi.decrypto.entites;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jakarta.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PartieEntityTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testPartieEntityMapping() {
        // Créer des objets Users et Personnage pour les relations
        Users user = new Users();
        user.setName("Test User");
        entityManager.persist(user);

        Personnage personnage = new Personnage();
        personnage.setNom("Test Personnage");
        entityManager.persist(personnage);

        // Créer une instance de Partie
        Partie partie = new Partie();
        partie.setUser(user);
        partie.setPersonnage(personnage);
        partie.setPts(100);
        partie.setDate(LocalDateTime.now());

        // Persister l'entité Partie
        entityManager.persist(partie);
        entityManager.flush();

        // Récupérer l'entité persister et vérifier les valeurs
        Partie found = entityManager.find(Partie.class, partie.getId());

        assertThat(found).isNotNull();
        assertThat(found.getUser()).isEqualTo(user);
        assertThat(found.getPersonnage()).isEqualTo(personnage);
        assertThat(found.getPts()).isEqualTo(100);
        assertThat(found.getDate()).isNotNull();
    }
}
