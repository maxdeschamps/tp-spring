package com.tpspring.repositories;

import com.tpspring.entities.ProjetParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetParticipantRepository extends JpaRepository<ProjetParticipant, Integer> {
    @Query("select pu from ProjetParticipant pu where pu.projet = ?1 and pu.participant = ?2")
    ProjetParticipant findParticipationByProjetAndUtilisateur(Integer projetId, Integer utilisateurId);
}
