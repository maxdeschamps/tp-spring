package com.tpspring.repositories;

import com.tpspring.entities.Projet;
import com.tpspring.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Integer>, PagingAndSortingRepository<Projet, Integer> {
    @Query("select p.abonnes, p.auteur from Projet p where p.id = ?1")
    List<Utilisateur> findAllAbonneInProjet(Integer projetId);
}
