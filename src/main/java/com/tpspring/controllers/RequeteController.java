package com.tpspring.controllers;

import com.tpspring.entities.Requete;
import com.tpspring.services.RequeteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RequeteController {
    @Autowired
    private RequeteService requeteService;

    @Operation(summary = "Récupération d'un requête à partir de son identifiant")
    @RequestMapping(path = "/requete", method = RequestMethod.GET)
    public Requete getRequete(@RequestParam(value = "id") Integer id) {
        return requeteService.getRequeteById(id);
    }

    @Operation(summary = "Création ou mise à jour d'une requête")
    @RequestMapping(path = "/requete", method = RequestMethod.PUT)
    public Requete addOrUpdateRequete(@Valid @RequestBody Requete requete) {
        return requeteService.createOrUpdate(requete);
    }
}
