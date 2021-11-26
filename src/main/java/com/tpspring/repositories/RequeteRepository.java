package com.tpspring.repositories;

import com.tpspring.entities.Requete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RequeteRepository extends JpaRepository<Requete, Integer> {
    @Query("select r from Requete r where r.projet = ?1")
    Requete findAllRequetesByProjet(Integer projetId);

    @Query("select r from Requete r where r.auteur = ?1")
    Requete findAllRequetesByUtilisateur(Integer utilisateurId);
}
