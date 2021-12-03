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
    private ProjetDTO projetDTO;
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

    public ProjetDTO getProjetDTO() {
        return projetDTO;
    }

    public void setProjetDTO(Projet projet) {
        this.projetDTO = new ProjetDTO(projet);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Boolean getValide() {
        return valide;
    }

    @Override
    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    @Override
    public String getRequete() {
        return requete;
    }

    @Override
    public void setRequete(String requete) {
        this.requete = requete;
    }

    @Override
    public Date getDateCreation() {
        return dateCreation;
    }

    @Override
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
