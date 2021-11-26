package com.tpspring.repositories;

import com.tpspring.entities.ProjetParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetParticipantRepository extends JpaRepository<ProjetParticipant, Integer> {
    @Query("select pp from ProjetParticipant pp where pp.projet.id = ?1 and pp.participant.id = ?2")
    ProjetParticipant findParticipationByProjetAndUtilisateur(Integer projetId, Integer utilisateurId);
}
