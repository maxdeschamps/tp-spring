package com.tpspring.services;

import com.tpspring.dto.ProjetDTO;
import com.tpspring.entities.Projet;
import com.tpspring.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetService {
    @Autowired
    private ProjetRepository projetRepository;
    @Autowired
    private UtilisateurService utilisateurService;

    public ProjetDTO createOrUpdate(Projet projet) {
        if (projet.getAuteur() == null) {
            projet.setAuteur(utilisateurService.createDefaultUtilisateur());
        }
        if (projet.getDateCreation() == null) {
            projet.setDateCreation(new Date());
        }

        projet.setDateModification(new Date());

        projetRepository.save(projet);
        return new ProjetDTO(projet);
    }

    public ProjetDTO getProjetById(Integer id) {
        Projet projet = projetRepository.findById(id).orElse(null);
        return new ProjetDTO(projet);
    }

    public List<ProjetDTO> getAllProjets() {
        return projetRepository.findAll().stream().map(ProjetDTO::new).collect(Collectors.toList());
    }

    public void deleteProjet(Projet projet) {
        projetRepository.delete(projet);
    }

}