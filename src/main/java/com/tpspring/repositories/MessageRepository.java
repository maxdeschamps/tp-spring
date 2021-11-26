package com.tpspring.repositories;

import com.tpspring.entities.Message;
import com.tpspring.entities.Requete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("select m from Message m where m.projet = ?1")
    Requete findAllMessagesByProjet(Integer projetId);

    @Query("select m from Message m where m.utilisateur = ?1")
    Requete findAllMessagesByUtilisateur(Integer utilisateurId);
}
