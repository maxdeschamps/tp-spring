package com.tpspring.services;

import com.tpspring.entities.Poste;
import com.tpspring.entities.Service;
import com.tpspring.entities.Utilisateur;
import com.tpspring.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public Service createDefaultService() {
        Service service = (serviceRepository.getByNom("Lyon") == null)
                ? new Service()
                : serviceRepository.getByNom("Lyon");

        if (service.getNom() == null) {
            service.setNom("Lyon");
            serviceRepository.save(service);
        }

        return service;
    }
}