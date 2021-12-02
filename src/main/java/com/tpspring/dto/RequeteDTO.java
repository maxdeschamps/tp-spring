package com.tpspring.dto;

import com.tpspring.entities.Requete;

import com.tpspring.entities.Projet;
import com.tpspring.entities.Requete;
import com.tpspring.entities.Utilisateur;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class RequeteDTO extends Requete {
    private Integer id;
    private Boolean valide;
    private String requete;
    private Date dateCreation;
    private UtilisateurDTO auteurDTO;

    public RequeteDTO(Requete r) {
        this.setId(r.getId());
        this.setValide(r.getValide());
        this.setRequete(r.getRequete());
        this.setDateCreation(r.getDateCreation());
        this.setAuteurDTO(r.getAuteur());
    }

    public UtilisateurDTO getAuteurDTO() {
        return auteurDTO;
    }

    public void setAuteurDTO(Utilisateur auteur) {
        this.auteurDTO = new UtilisateurDTO(auteur);
    }
}
