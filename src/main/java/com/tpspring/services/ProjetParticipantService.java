package com.tpspring.services;

import com.tpspring.entities.ProjetParticipant;
import com.tpspring.repositories.ProjetParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetParticipantService {
    @Autowired
    private ProjetParticipantRepository projetParticipantRepository;

    public ProjetParticipant createOrUpdate(ProjetParticipant projetParticipant) {
        return projetParticipantRepository.save(projetParticipant);
    }

    public ProjetParticipant getProjetParticipantByProjetAndUtilisateur(Integer projetId, Integer utilisateurId) {
        return projetParticipantRepository.findParticipationByProjetAndUtilisateur(projetId, utilisateurId);
    }
}