package com.tpspring.services;

import com.tpspring.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
}