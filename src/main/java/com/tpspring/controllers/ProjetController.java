package com.tpspring.controllers;

import com.tpspring.dto.ProjetDTO;
import com.tpspring.entities.Projet;
import com.tpspring.services.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjetController {
    @Autowired
    private ProjetService projetService;
    @Autowired
    private NotificationService notificationService;

    @Operation(summary = "Récupération d'un projet à partir de son identifiant")
    @RequestMapping(path = "/projet", method = RequestMethod.GET)
    public ProjetDTO getProjet(@RequestParam(value = "id") Integer id) {
        return projetService.getProjetById(id);
    }

    @Operation(summary = "Création ou mise à jour d'un projet")
    @RequestMapping(path = "/projet", method = RequestMethod.PUT)
    public ProjetDTO addOrUpdateProjet(@Valid @RequestBody Projet projet) {
        ProjetDTO projetFinal = projetService.createOrUpdate(projet);
        notificationService.notificationNouveauProjet(projetFinal);
        return projetFinal;
    }

    @Operation(summary = "Récupération de tous les projets")
    @RequestMapping(path = "/projets/all", method = RequestMethod.GET)
    public List<ProjetDTO> getProjets() {
        return projetService.getAllProjets();
    }

    @Operation(summary = "Suppression d'un projet à partir de son identifiant")
    @RequestMapping(path = "/projet", method = RequestMethod.DELETE)
    public void deleteProjet(@RequestParam(value = "id") Integer id) {
        projetService.deleteProjet(projetService.getProjetById(id));
    }
}
