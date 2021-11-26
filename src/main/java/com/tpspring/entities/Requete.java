package com.tpspring.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "requetes")
public class Requete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="valide")
    private Boolean valide;
    @Column(name="requete")
    @NotNull
    private String requete;
    @Column(name="date_creation")
    @NotNull
    private Date dateCreation;
    // Le projet relié à la requête
    @ManyToOne
    @JoinColumn(name="projet_id", nullable=false)
    private Projet projet;
    // L'auteur de la requête
    @ManyToOne
    @JoinColumn(name="utilisateur_id", nullable=false)
    private Utilisateur auteur;

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    public String getRequete() {
        return requete;
    }

    public void setRequete(String requete) {
        this.requete = requete;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }
}
