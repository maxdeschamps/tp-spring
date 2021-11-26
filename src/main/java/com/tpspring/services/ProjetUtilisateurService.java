package com.tpspring.services;

import com.tpspring.entities.Poste;
import com.tpspring.entities.ProjetUtilisateur;
import com.tpspring.entities.Utilisateur;
import com.tpspring.repositories.ProjetUtilisateurRepository;
import com.tpspring.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetUtilisateurService {
    @Autowired
    private ProjetUtilisateurRepository projetUtilisateurRepository;

    public ProjetUtilisateur createOrUpdate(ProjetUtilisateur projetUtilisateur) {
        return projetUtilisateurRepository.save(projetUtilisateur);
    }

    public ProjetUtilisateur getProjetUtilisateurByProjetAndUtilisateur(Integer projetId, Integer utilisateurId) {
        return projetUtilisateurRepository.findParticipationByProjetAndUtilisateur(projetId, utilisateurId);
    }
}