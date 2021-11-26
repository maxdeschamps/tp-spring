package com.tpspring.services;

import com.tpspring.entities.Projet;
import com.tpspring.repositories.ProjetRepository;
import com.tpspring.repositories.UtilisateurRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {
    @Autowired
    private ProjetRepository projetRepository;
    @Autowired
    private UtilisateurService utilisateurService;

    public Projet createOrUpdate(Projet projet) {
        if (projet.getAuteur() == null) {
            projet.setAuteur(utilisateurService.createDefaultUtilisateur());
        }
        return projetRepository.save(projet);
    }

    public Projet getProjetById(Integer id) {
        return projetRepository.findById(id).orElse(null);
    }

    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }

    public void deleteProjet(Projet projet) {
        projetRepository.delete(projet);
    }

}