package com.tpspring.repositories;

import com.tpspring.entities.Requete;
import com.tpspring.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur getByPseudo(String pseudo);

    @Query("select u from Utilisateur u where u.notification_projet = true")
    List<Utilisateur> findAllUtilisateurNotificationNouveauProjet();
}
