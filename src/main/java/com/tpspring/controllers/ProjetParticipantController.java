package com.tpspring.controllers;

import com.tpspring.entities.ProjetParticipant;
import com.tpspring.services.ProjetParticipantService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProjetParticipantController {
    @Autowired
    private ProjetParticipantService projetParticipantService;

    @Operation(summary = "Vote sur un participant (approbation ou refus) pour un projet")
    @RequestMapping(path = "/projet/vote-on-participant", method = RequestMethod.GET)
    public void voteOnParticipant(@RequestParam(value = "projetId") Integer projetId,
                                  @RequestParam(value = "participantId") Integer participantId,
                                  @RequestParam(value = "approbation") boolean approbation
    ) {
        ProjetParticipant projetParticipant = projetParticipantService.getProjetParticipantByProjetAndUtilisateur(projetId, participantId);

        if (projetParticipant != null) {
            projetParticipant.setValide(approbation);
            projetParticipantService.createOrUpdate(projetParticipant);
        }
    }

    @Operation(summary = "Suppression d'un participant d'un projet à partir de son identifiant")
    @RequestMapping(path = "/projet/delete-participant", method = RequestMethod.DELETE)
    public void deleteProjet(@RequestParam(value = "projet") Integer projet, @RequestParam(value = "utilisateur") Integer utilisateur) {
        projetParticipantService.deleteParticipant(projet, utilisateur);
    }
}
