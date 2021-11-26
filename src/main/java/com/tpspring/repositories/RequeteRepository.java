package com.tpspring.repositories;

import com.tpspring.entities.Requete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequeteRepository extends JpaRepository<Requete, Integer> {
    @Query("select r from Requete r where r.projet = ?1")
    Requete findAllRequetesByProjetId(Integer projetId);
}
