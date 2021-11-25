package com.tpspring.services;

import com.tpspring.entities.Utilisateur;
import com.tpspring.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

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