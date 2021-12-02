package com.tpspring.services;

import com.tpspring.entities.Poste;
import com.tpspring.entities.Utilisateur;
import com.tpspring.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private ServiceService serviceService;

    public Utilisateur createDefaultUtilisateur() {
        Utilisateur utilisateur = (utilisateurRepository.getByPseudo("dede") == null)
                ? new Utilisateur()
                : utilisateurRepository.getByPseudo("dede");

        if (utilisateur.getNom() == null) {
            utilisateur.setPrenom("Default");
            utilisateur.setNom("User");
            utilisateur.setPoste(Poste.CHERCHEUR);
            utilisateur.setPseudo("dede");
            utilisateur.setMotDePasse("123");
            utilisateur.setNotification_projet(true);

            utilisateur.setService(serviceService.createDefaultService());
            utilisateurRepository.save(utilisateur);
        }
        return utilisateur;
    }

    public Utilisateur createOrUpdate(Utilisateur utilisateur) {
//        if (StringUtils.isNotEmpty(utilisateur.getPassword())) {
//            utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
//        }
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUtilisateurById(Integer id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public void deleteUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.delete(utilisateur);
    }

}