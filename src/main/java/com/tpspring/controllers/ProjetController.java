package com.tpspring.controllers;

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

    @Operation(summary = "Récupération d'un utilisateur à partir de son identifiant")
    @RequestMapping(path = "/projet", method = RequestMethod.GET)
    public Projet getProjet(@RequestParam(value = "id") Integer id) {
        return projetService.getProjetById(id);
    }

    @Operation(summary = "Création ou mise à jour d'un utilisateur")
    @RequestMapping(path = "/projet", method = RequestMethod.PUT)
    public Projet addOrUpdateProjet(@Valid @RequestBody Projet projet) {
        return projetService.createOrUpdate(projet);
    }

    @Operation(summary = "Récupération de tous les utilisateurs")
    @RequestMapping(path = "/projets/all", method = RequestMethod.GET)
    public List<Projet> getProjets() {
        return projetService.getAllProjets();
    }

    @Operation(summary = "Suppression d'un utilisateur à partir de son identifiant")
    @RequestMapping(path = "/projet", method = RequestMethod.DELETE)
    public void deleteProjet(@RequestParam(value = "id") Integer id) {
        projetService.deleteProjet(projetService.getProjetById(id));
    }
}
