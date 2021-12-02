package com.tpspring.dto;

import com.tpspring.entities.Requete;

import java.util.Date;

public class RequeteDTO extends Requete {
    private Integer id;
    private Boolean valide;
    private String requete;
    private Date dateModification;


    public RequeteDTO(Requete r) {
        this.setId(r.getId());
        this.setValide(r.getValide());
        this.setRequete(r.getRequete());
        this.setDateCreation(r.getDateCreation());
    }
}
