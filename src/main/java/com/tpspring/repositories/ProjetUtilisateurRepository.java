package com.tpspring.repositories;

import com.tpspring.entities.ProjetUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetUtilisateurRepository extends JpaRepository<ProjetUtilisateur, Integer> {

}
