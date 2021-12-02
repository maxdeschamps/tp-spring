package com.tpspring.services;

import com.tpspring.dto.RequeteDTO;
import com.tpspring.entities.Requete;
import com.tpspring.repositories.RequeteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RequeteService {
    @Autowired
    private RequeteRepository requeteRepository;

    public RequeteDTO createOrUpdate(Requete requete) {
        if (requete.getDateCreation() == null) {
            requete.setDateCreation(new Date());
        }

        requeteRepository.save(requete);
        return new RequeteDTO(requete);
    }

    public RequeteDTO getRequeteById(Integer id) {
        Requete requete = requeteRepository.findById(id).orElse(null);
        return new RequeteDTO(requete);
    }

    public void deleteRequete(Requete requete) {
        requeteRepository.delete(requete);
    }
}