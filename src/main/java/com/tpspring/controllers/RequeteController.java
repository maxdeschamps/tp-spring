package com.tpspring.controllers;

import com.tpspring.dto.ProjetDTO;
import com.tpspring.dto.RequeteDTO;
import com.tpspring.entities.Projet;
import com.tpspring.entities.Requete;
import com.tpspring.services.RequeteService;
import com.tpspring.services.NotificationService;
import com.tpspring.services.ProjetService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RequeteController {
    @Autowired
    private RequeteService requeteService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private ProjetService projetService;

    @Operation(summary = "Récupération d'un requête à partir de son identifiant")
    @RequestMapping(path = "/requete", method = RequestMethod.GET)
    public RequeteDTO getRequete(@RequestParam(value = "id") Integer id) {
        return requeteService.getRequeteById(id);
    }

    @Operation(summary = "Création ou mise à jour d'une requête")
    @RequestMapping(path = "/requete", method = RequestMethod.PUT)
    public RequeteDTO addOrUpdateRequete(@Valid @RequestBody Requete requete) {
        RequeteDTO requeteFinal = requeteService.createOrUpdate(requete);
        Projet projet = requeteFinal.getProjetDTO();
        ProjetDTO projetFinal = projetService.getProjetById(projet.getId());
        notificationService.notificationNouvelleRequete(requeteFinal, projetFinal);
        return requeteFinal;
    }

    @Operation(summary = "Suppression d'une requête à partir de son identifiant")
    @RequestMapping(path = "/requete", method = RequestMethod.DELETE)
    public void deleteRequete(@RequestParam(value = "id") Integer id) {
        requeteService.deleteRequete(requeteService.getRequeteById(id));
    }
}
