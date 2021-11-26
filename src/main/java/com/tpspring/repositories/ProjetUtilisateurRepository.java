package com.tpspring.repositories;

import com.tpspring.entities.Projet;
import com.tpspring.entities.ProjetUtilisateur;
import com.tpspring.entities.Requete;
import com.tpspring.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetUtilisateurRepository extends JpaRepository<ProjetUtilisateur, Integer> {

    @Query("select pu from ProjetUtilisateur pu where pu.projet = ?1 and pu.utilisateur = ?2")
    Requete findParticipationByProjetAndUtilisateur(Integer projetId, Integer utilisateurId);
}
