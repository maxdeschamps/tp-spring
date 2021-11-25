package com.tpspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjetController {
    @Autowired
    private ProjetService projetService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private RequeteService requeteService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private MotCleService motCleService;
}
